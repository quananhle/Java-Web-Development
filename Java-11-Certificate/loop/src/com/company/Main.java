package com.company;

public class Main {

    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        //for loop
        for (int i = 0; i < months.length; i++) {
            if (i == months.length - 1) {
                System.out.print(months[i] +".");
            }
            else {
                System.out.print(months[i] +", ");
            }
        }
        System.out.print("\n");
        //for each
        for (var month : months) {
            if (month == months[months.length - 1]) {
                System.out.print(months[months.length - 1] +".");
            }
            else {
                System.out.print(month +", ");
            }
        }
        System.out.print("\n");
        //while loop
        var whileCounter = 0;
        while (whileCounter < months.length) {
            if (whileCounter == months.length - 1) {
                System.out.print(months[whileCounter] +".");
            }
            else {
                System.out.print(months[whileCounter] +", ");
            }
            //incrementing the counter
            whileCounter++;
        }
        System.out.print("\n");
        //do loop
        var doCounter = 0;
        do {
            if (doCounter == months.length - 1) {
                System.out.print(months[doCounter] +".");
            }
            else {
                System.out.print(months[doCounter] +", ");
            }
            //incrementing the counter
            doCounter++;
        } while (doCounter < months.length);
    }
}
