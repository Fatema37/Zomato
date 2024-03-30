package org.example.repositories;

import org.example.models.Booking;

import java.util.HashMap;
import java.util.Optional;

public class BookingRepo {
    HashMap<String, Booking> bookingHashMap = new HashMap<>();
    Long id = 0L;

    public Optional<Booking> save(Booking booking){
        if(booking.getBookingId()==null){
            id++;
            booking.setBookingId(id.toString());
        }
        bookingHashMap.put(booking.getBookingId(), booking);
        return Optional.of(booking);
    }

    public Optional<Booking> findById(String id){
        if(bookingHashMap.containsKey(id)){
            return Optional.of(bookingHashMap.get(id));
        }
        else {
            return Optional.empty();
        }
    }



}
