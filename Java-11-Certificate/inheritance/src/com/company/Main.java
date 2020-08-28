package com.company;

import com.company.model.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
    	//Array
		ClothingItem[] items = {
				new Shirt(ClothingSize.L, 19.99, 3),
				new Hat(ClothingSize.M, 29.99, 1)
		};
		//List
		List<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Yellow");

		//for each loop
		for (String color : colors) {
			System.out.println(color);
		}
		for (ClothingItem item : items) {
			displayItemDetails(item);
		}

		//Hash Map
		Map<String, ClothingItem> merchandise = new HashMap<>();
		merchandise.put("pants", new Pants(ClothingSize.L, 29.99, 3));
		merchandise.put("shoes", new Shoes(ClothingSize.XL, 109.99, 2));
		var keys = merchandise.keySet();
		for (String key : keys) {
			var aMerchandise = merchandise.get(key);
			displayItemDetails(aMerchandise);
		}
	}

	private static void displayItemDetails(ClothingItem item) {
		var totalPrice = item.getPrice() * item.getQuantity();
		var formatter = NumberFormat.getCurrencyInstance();
		var output = String.format("Your %s %s %s order will cost %s", item.getQuantity(), item.getSize(),
				item.getType(), formatter.format(totalPrice));
		System.out.println(output);
	}
}
