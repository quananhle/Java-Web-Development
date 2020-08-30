package com.company;

import java.io.*;
import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) {
        scanner();
        createFile();
        bufferedReader();
    }
    //Creating a new file
    public static void createFile() {
        File myFile = new File("index.txt");
        try {
            myFile.createNewFile();
        }
        catch (IOException ioe) {
            System.out.println("No file created");
        }
    }
    //Reading console input with a scanner
    public static void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        System.out.print("Enter the phone number: ");
        String number = scanner.next();
        Person person = new Person(name, age, number);
    }
    //Reading file with BufferedReader
    public static void bufferedReader() {
        //Reading file with BufferedReader
        File myFile = new File("index.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ioe) {
            System.out.println("No input found");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new StringReader("Hello World!"));
             StringWriter writer = new StringWriter();)
        {
            writer.write(bufferedReader.readLine());
            System.out.println(writer.toString());
        }
        catch (IOException ioException) {
            System.out.println("No input found");
        }
    }
}
