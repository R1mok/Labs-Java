package ru.mephi.lab6.homework.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01BufferedReader {
    
    public static void main(String[] args) {
        
        try{
            BufferedReader bReader = 
                new BufferedReader(new FileReader("Labs/src/main/java/ru/mephi/lab6/homework/task1/hamlet.txt"));
            
            System.out.println("=== Entire File ===");
            //print out file here
            String line = "";
            while (line != null) {
                System.out.println(line);
                line = bReader.readLine();
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
