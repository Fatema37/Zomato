package org.example.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    private String userId;
    private String restaurantId;

    private String bookingTime;
    private String bookingDate;
    private int noOfPeople;
    private boolean isCancelled;
    private Slot slot;
    private String tableNo;





    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    public boolean setIsCancelled(boolean isCancelled) {
        return this.isCancelled = isCancelled;
    }




    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", noOfPeople=" + noOfPeople +
                ", isCancelled=" + isCancelled +
                ", slot=" + slot +
                ", tableNo='" + tableNo + '\'' +
                '}';
    }
}
