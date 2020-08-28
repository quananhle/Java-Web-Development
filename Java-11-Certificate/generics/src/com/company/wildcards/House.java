package com.company.wildcards;

public class House extends Building {
    public int numberRooms = 3;

    @Override
    public String toString() {
        return ("House{}");
    }
    public int getNumberRooms() {
        return numberRooms;
    }
    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }
}
