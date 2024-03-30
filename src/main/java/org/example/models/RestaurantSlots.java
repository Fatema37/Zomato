package org.example.models;

import java.time.LocalDate;
import java.util.List;

public class RestaurantSlots {

   private LocalDate date;
   private List<SlotTableMapping> slots;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<SlotTableMapping> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotTableMapping> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "RestaurantSlots{" +
                "date=" + date +
                ", slots=" + slots +
                '}';
    }
}
