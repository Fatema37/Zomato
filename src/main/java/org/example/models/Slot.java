package org.example.models;

import java.time.LocalDateTime;

public class Slot {
    private String slotId;
    private LocalDateTime slotStartTime;
    private LocalDateTime slotEndTime;

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public LocalDateTime getSlotStartTime() {
        return slotStartTime;
    }

    public void setSlotStartTime(LocalDateTime slotStartTime) {
        this.slotStartTime = slotStartTime;
    }

    public LocalDateTime getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(LocalDateTime slotEndTime) {
        this.slotEndTime = slotEndTime;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId='" + slotId + '\'' +
                ", slotStartTime=" + slotStartTime +
                ", slotEndTime=" + slotEndTime +
                '}';
    }
}
