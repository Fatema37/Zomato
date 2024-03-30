package org.example.models;

public class Table {
    private String tableId;
    private int tableCapacity;
    private boolean isAvailable;


    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

    public void setTableCapacity(int tableCapacity) {
        this.tableCapacity = tableCapacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId='" + tableId + '\'' +
                ", tableCapacity=" + tableCapacity +
                ", isOccupied=" + isAvailable +
                '}';
    }
}
