package ru.mephi.lab5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    protected static void readFailingFile() throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(new File("filename")));
        rd.readLine();
    }
    public static class Test1 {
        private int[] arr;
    }

    public static void main(String[] args) throws Exception {
        try {
            int[] a = new int[3];
            a[4] = 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catch ArrayIndexOutOfBoundsException");
        }
        try {
            readFailingFile();
        } catch (FileNotFoundException e) {
            System.out.println("Catch FileNotFoundException");
        }
        try {
            Test1 t1 = new Test1();
            t1.arr[0] = 1;
        } catch (NullPointerException e) {
            System.out.println("Catch NullPointerException");
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (IOException e) {
            System.out.println("Catch IOException");
        }
        try {
            Object primitives = new int[1];
            Integer[] integers = (Integer[]) primitives;
        } catch (ClassCastException e) {
            System.out.println("Catch ClassCastException");
        }
        try {
            int n = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Catch ArithmeticException");
        }
    }
}
