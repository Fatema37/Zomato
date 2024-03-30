package org.example.services;

import org.example.models.*;
import org.example.repositories.BookingRepo;
import org.example.repositories.RestaurantRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private BookingRepo bookingRepo;
    private RestaurantRepo restaurantRepo;

    public BookingService(BookingRepo bookingRepo, RestaurantRepo restaurantRepo) {
        this.bookingRepo = bookingRepo;
        this.restaurantRepo = restaurantRepo;
    }

    public Booking bookTable(String userId, String restaurantId, int noOfPeople, LocalDateTime bookingDateTime) {
        if (bookingDateTime.toLocalDate().isAfter(LocalDate.now().plusDays(2))) {
            throw new RuntimeException("Booking can be done only 7 days in advance");
        }

        Optional<Restaurant> restaurantOptional = restaurantRepo.findById(restaurantId);
        if (restaurantOptional.isEmpty()) {
            throw new RuntimeException("Restaurant not found");
        }
        Restaurant restaurant = restaurantOptional.get();

        List<RestaurantSlots> restaurantSlots = restaurant.getRestaurantSlots();
        for (RestaurantSlots restaurantSlot : restaurantSlots) {
            if (restaurantSlot.getDate().equals(bookingDateTime.toLocalDate())) {
                List<SlotTableMapping> slots = restaurantSlot.getSlots();
                for (SlotTableMapping slot : slots) {
                    LocalDateTime slotStartTime = slot.getSlot().getSlotStartTime();
                    LocalDateTime slotEndTime = slot.getSlot().getSlotEndTime();

                    // Check if the booking time falls within the slot time
                    if ((bookingDateTime.isAfter(slotStartTime) || bookingDateTime.equals(slotStartTime))
                            && (bookingDateTime.isBefore(slotEndTime)) || bookingDateTime.equals(slotEndTime)) {
                        // Check if there are available tables
                        List<Table> availableTables = slot.getTableList();
                        boolean tableAvailable = availableTables.stream().anyMatch(Table::isAvailable);

                        if (tableAvailable) {
                            // Book the table
                            for (Table table : availableTables) {
                                if (table.isAvailable() && table.getTableCapacity() >= noOfPeople) {
                                    table.setAvailable(false);
                                    return createAndSaveBooking(userId, restaurantId, noOfPeople, bookingDateTime, table,slot.getSlot());
                                }
                            }
                            throw new RuntimeException("No available tables for the selected time");
                        }
                    }
                }
            }
        }
        throw new RuntimeException("No available slots for the selected time");
    }

    private Booking createAndSaveBooking(String userId, String restaurantId, int noOfPeople, LocalDateTime bookingDateTime, Table table,Slot slot) {
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setRestaurantId(restaurantId);
        booking.setNoOfPeople(noOfPeople);
        booking.setBookingTime(bookingDateTime.toString());
        booking.setBookingDate(bookingDateTime.toLocalDate().toString());
        booking.setIsCancelled(false);
        booking.setTableNo(table.getTableId());
        booking.setSlot(slot);

        bookingRepo.save(booking);
        System.out.println("Booking done successfully" + booking);
        return booking;
    }

}
