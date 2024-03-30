package org.example;


import org.example.models.Booking;
import org.example.models.CuisineType;
import org.example.models.Slot;
import org.example.repositories.BookingRepo;
import org.example.repositories.RestaurantRepo;
import org.example.repositories.UserRepo;
import org.example.services.BookingService;
import org.example.services.RestaurantService;
import org.example.services.UserService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        UserRepo userRepo = new UserRepo();
        RestaurantRepo restaurantRepo = new RestaurantRepo();
        BookingRepo bookingRepo = new BookingRepo();
        BookingService bookingService = new BookingService(bookingRepo, restaurantRepo);

        UserService userService = new UserService(userRepo);
        userService.registerUser("fatemagmail.com", "1234", "Fatema", "1234567890");
        userService.loginUser("fatemagmail.com", "1234");

        RestaurantService restaurantService = new RestaurantService(restaurantRepo, userService, userRepo);
        restaurantService.RegisterRestaurant("KFC", "Dhaka", "Gulshan", CuisineType.NON_VEGETARIAN, 500, "1234567890");
       restaurantService.RegisterRestaurant("Al-Baik", "Bangalore", "Gottigere", CuisineType.NON_VEGETARIAN, 1000, "1234467890");
       restaurantService.SearchRestaurant("KFC", "Dhaka", "Gulshan", CuisineType.NON_VEGETARIAN, 500,  "1");

       bookingService.bookTable("1","1",4, LocalDateTime.of(2024,3,30,19, 0, 0));





        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}
