package com.company.model;

public class Shoes extends ClothingItem {
    public Shoes(ClothingSize size, double price, int quantity) {
        super(ClothingItem.PANTS, size, price, quantity);
    }
}