package ru.mephi.lab5;

import java.util.HashSet;

public class OutOfMemoryExample {
    public static int calculateFactorial(int number) {
        return number * calculateFactorial(number - 1);
    }
    static final HashSet set = new HashSet();

    public static void crash() {
        while (true) {
            set.add(new int[10000000]);
        }
    }
    public static void main(String[] args) {
       try{
           crash();
       } catch (OutOfMemoryError e){
           System.out.println("Catch OutOfMemoryError");
       }
       try {
           calculateFactorial(1);
       } catch (StackOverflowError e){
           System.out.println("Catch StackOverflowError");
       }
    }
}