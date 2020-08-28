package com.company.wildcards;

public class Building {
    public int numberRooms = 7;

    @Override
    public String toString() {
        return ("Building");
    }

    public int getNumberRooms() {
        return numberRooms;
    }
    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }
}
