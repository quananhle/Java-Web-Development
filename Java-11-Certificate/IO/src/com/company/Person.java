package com.company;

import java.text.NumberFormat;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;

    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        System.out.print("Person Created." + "\n" + "Name: " + name + "\n" +
                "Age: " + age + "\n" + "Phone number: " + phoneNumber.replaceFirst
                ("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3") + "\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
