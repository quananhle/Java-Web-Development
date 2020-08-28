package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true};

    public static <T> List<T> arrayToList(T[] array, List<T> list) {
        for (T object : array) {
            list.add(object);
        }
        return list;
    }

    public static void main(String[] args) {
	    List<Character> characterList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> booleanList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> integerList = arrayToList(intArray, new ArrayList<>());
        System.out.println(integerList.get(0));
    }
}
