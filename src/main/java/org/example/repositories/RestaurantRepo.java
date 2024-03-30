package org.example.repositories;

import org.example.models.CuisineType;
import org.example.models.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RestaurantRepo {
    HashMap<String, Restaurant> restaurantHashMap = new HashMap<>();
    Long id = 0L;

    public Restaurant save(Restaurant restaurant){
        if(restaurant.getId()==null){
        id++;
        restaurant.setId(id.toString());
        }
        restaurantHashMap.put(restaurant.getId(), restaurant);
        return restaurant;
    }

    public Optional<Restaurant> findById(String id){
        if(restaurantHashMap.containsKey(id)){
            return Optional.of(restaurantHashMap.get(id));
        }
        else {
            return Optional.empty();
        }
    }
    public Optional<Restaurant> findByPhoneNumber(String phoneNumber){
        for(Restaurant restaurant : restaurantHashMap.values()){
            if(restaurant.getPhoneNo().equals(phoneNumber)){
                return Optional.of(restaurant);
            }
        }
        return Optional.empty();
    }

    public Optional<List<Restaurant>> findByCity(String city) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : restaurantHashMap.values()) {
            if (restaurant.getCity().equalsIgnoreCase(city)) {
                result.add(restaurant);
            }
        }
        return Optional.of(result);
    }

    public Optional<List<Restaurant>> findByArea(String area, String city) {
        return getRestaurants(area, city);
    }

    public Optional<List<Restaurant>> findByCuisine(CuisineType cuisine) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : restaurantHashMap.values()) {
            if (restaurant.getCuisine().equals(cuisine)) {
                result.add(restaurant);
            }
        }
        return Optional.of(result);
    }

    public Optional<Restaurant> findByName(String name){
        for(Restaurant restaurant : restaurantHashMap.values()){
            if(restaurant.getName().equals(name)){
                return Optional.of(restaurant);
            }
        }
        return Optional.empty();
    }

    public Optional<List<Restaurant>> findByAreaAndCity(String area, String city){
        return getRestaurants(area, city);
    }

    private Optional<List<Restaurant>> getRestaurants(String area, String city) {
        List<Restaurant> result = new ArrayList<>();
        for(Restaurant restaurant : restaurantHashMap.values()){
            if(restaurant.getArea().equalsIgnoreCase(area) && restaurant.getCity().equalsIgnoreCase(city)){
                result.add(restaurant);
            }
        }
        return Optional.of(result);
    }

    public Optional<List<Restaurant>> findByCostForTwo(double costForTwo){
        List<Restaurant> result = new ArrayList<>();
        for(Restaurant restaurant : restaurantHashMap.values()){
            if(restaurant.getCostForTwo() == costForTwo){
                result.add(restaurant);
            }
        }
        return Optional.of(result);
    }

}
