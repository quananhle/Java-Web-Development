package com.company;

import com.company.wildcards.Building;
import com.company.wildcards.House;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true};

    //generic method
    public static <T> List<T> arrayToList(T[] array, List<T> list) {
        for (T object : array) {
            list.add(object);
        }
        return list;
    }

    //varargs method
    public static void printShoppinglist(String... items) {
        System.out.println("SHOPPING LIST");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i+1 + ": " + items[i]);
        }
        System.out.println("\n");
    }

    //wildcards
    static void displayBuildings(List<? extends Building> buildings) {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).toString() + " " + (i + 1));
        }
        System.out.print("\n");
    }
    static void addHouses(List<? super House> buildings) {
        buildings.add(new House());
        System.out.print("\n");
    }

    public static void main(String[] args) {
	    List<Character> characterList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> booleanList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> integerList = arrayToList(intArray, new ArrayList<>());
        System.out.println(integerList.get(0));
        printShoppinglist("Bread", "Milk", "Eggs", "Bacon", "Veggie");
    }
}
