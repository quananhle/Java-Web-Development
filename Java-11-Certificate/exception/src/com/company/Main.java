package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String s = "";
	    try {
	        var sub = s.substring(1);
        }
	    catch (NullPointerException e) {
	        e.printStackTrace();
	        System.out.println("Null pointer: " + e.getMessage());
        }
	    catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Out of bounds: " + e.getMessage());
        }
	    catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception: " + e.getMessage());
        }
	    System.out.println("Not zombie yet!");
        System.out.println("File exist: " + file.exists());

        var file = new File("text.txt");

        //prevent memory leak
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader);){
            var text = br.readLine();
            System.out.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
