package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private  String id;
    private String name;
    private String city;
    private String area;
    private String phoneNo;
   private CuisineType cuisine;
   private double costForTwo;
    private String description;

    private List<RestaurantSlots> restaurantSlots;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public double getCostForTwo() {
        return costForTwo;
    }

    public void setCostForTwo(double costForTwo) {
        this.costForTwo = costForTwo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CuisineType getCuisine() {
        return cuisine;
    }

    public void setCuisine(CuisineType cuisine) {
        this.cuisine = cuisine;
    }



    public List<RestaurantSlots> getRestaurantSlots() {
        return restaurantSlots;
    }

    public void setRestaurantSlots(List<RestaurantSlots> restaurantSlots) {
        this.restaurantSlots = restaurantSlots;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", cuisine=" + cuisine +
                ", costForTwo=" + costForTwo +
                ", description='" + description + '\'' +
                ", restaurantSlots=" + restaurantSlots +
                '}';
    }
}
