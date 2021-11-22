package ru.mephi;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class ClassWorkTask2 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> m = new LinkedHashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        String str;
        while (scanner.hasNext()) {
            str = scanner.next();
            m.put(str, m.getOrDefault(str, 0) + 1);
        }
        for (Object strings : m.keySet()){
            System.out.print(strings + " ");
        }
    }
}