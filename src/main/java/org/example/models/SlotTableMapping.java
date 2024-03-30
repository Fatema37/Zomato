package org.example.models;

import java.util.List;

public class SlotTableMapping {
    private Slot slot;
    private List<Table> tableList;

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    @Override
    public String toString() {
        return "SlotTableMapping{" +
                "slot=" + slot +
                ", tableList=" + tableList +
                '}';
    }
}
