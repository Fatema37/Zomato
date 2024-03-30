package org.example.services;

import org.example.models.*;
import org.example.repositories.RestaurantRepo;
import org.example.repositories.UserRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class RestaurantService {
    private RestaurantRepo restaurantRepo;
    private UserService userService;
    private UserRepo userRepo;

    public RestaurantService(RestaurantRepo restaurantRepo ,UserService userService , UserRepo userRepo){
        this.restaurantRepo = restaurantRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    public Restaurant RegisterRestaurant(String name, String city, String area, CuisineType cuisine, double costForTwo , String phoneNo){
     Optional<Restaurant> restaurantOptional = restaurantRepo.findByPhoneNumber(phoneNo);
        if(restaurantOptional.isPresent()){
            throw new RuntimeException("Restaurant already exists");
        }
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setCity(city);
        restaurant.setArea(area);
        restaurant.setCuisine(cuisine);
        restaurant.setCostForTwo(costForTwo);
        restaurant.setPhoneNo(phoneNo);
        List<RestaurantSlots> restaurantSlots = initializeSlots();
        restaurant.setRestaurantSlots(restaurantSlots);
        restaurantRepo.save(restaurant);
        System.out.println("Restaurant is registered successfully" +restaurant);
        return restaurant;
    }

    public List<Restaurant> SearchRestaurant(String name, String city, String area , CuisineType cusine, double costForTwo, String userId) {
        Set<Restaurant> restaurants = new HashSet<>();
        Optional<User> userOptional = userRepo.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User does not exist");
        }
        if(userService.loginUser(userOptional.get().getEmail(), userOptional.get().getPassword()) == null){
            throw new RuntimeException("User not logged in");
        }
        Optional<List<Restaurant>> restaurantOptional = restaurantRepo.findByCity(city);
        Optional<List<Restaurant>> restaurantOptional1 = restaurantRepo.findByArea(area, city);
        Optional<List<Restaurant>> restaurantOptional2 = restaurantRepo.findByCuisine(cusine);
        Optional<Restaurant> restaurantOptional3 = restaurantRepo.findByName(name);
        Optional<List<Restaurant>> restaurantOptional4 = restaurantRepo.findByCostForTwo(costForTwo);
        Optional<List<Restaurant>> restaurantOptional5 = restaurantRepo.findByAreaAndCity(area,city);
        if(restaurantOptional.isPresent() || restaurantOptional1.isPresent() || restaurantOptional2.isPresent() || restaurantOptional3.isPresent() || restaurantOptional4.isPresent() || restaurantOptional5.isPresent()){
            restaurants.addAll(restaurantOptional.get());
            restaurants.addAll(restaurantOptional1.get());
            restaurants.addAll(restaurantOptional2.get());
            restaurants.add(restaurantOptional3.get());
            restaurants.addAll(restaurantOptional4.get());
            restaurants.addAll(restaurantOptional5.get());
        }
        System.out.println("Restaurants found successfully" +restaurants);
        return restaurants.stream().toList();
    }


    public List<RestaurantSlots> initializeSlots() {
        List<RestaurantSlots> restaurantSlots = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        List<Table> tables = initializeTable();

        // Iterate over 7 days
        for (int i = 0; i < 2; i++) {
            LocalDate date = currentDate.plusDays(i);
            RestaurantSlots slots = new RestaurantSlots();
            slots.setDate(date);

            List<SlotTableMapping> slotTableMappings = new ArrayList<>();
            // Generate slots for each day
            LocalTime startTime = LocalTime.of(18, 0); // Starting time
            while (startTime.isBefore(LocalTime.of(22, 0))) { // Assuming slots are till 10 PM
                SlotTableMapping slotTableMapping = new SlotTableMapping();
                Slot slot = new Slot();
                slot.setSlotStartTime(LocalDateTime.of(date, startTime));
                slot.setSlotEndTime(LocalDateTime.of(date, startTime.plusHours(1)));
                slotTableMapping.setSlot(slot);
                slotTableMapping.setTableList(tables);
                // Add slotTableMapping to the list
                slotTableMappings.add(slotTableMapping);
                // Increment the start time by 1 hour for the next slot
                startTime = startTime.plusHours(1);
            }
            // Set the slots for the day
            slots.setSlots(slotTableMappings);
            // Add the slots for the day to the list of restaurant slots
            restaurantSlots.add(slots);
        }

        return restaurantSlots;
    }

    public List<Table> initializeTable() {
        List<Table> tables = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Table table = new Table();
            table.setTableId("T" + i);
            table.setTableCapacity(4);
            table.setAvailable(true);
            tables.add(table);
        }
        return tables;
    }

}
