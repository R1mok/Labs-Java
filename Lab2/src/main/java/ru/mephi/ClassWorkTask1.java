package ru.mephi;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ClassWorkTask1 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> m = new LinkedHashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        String str;
        while (scanner.hasNext()) {
            str = scanner.next();
            m.put(str, m.getOrDefault(str, 0) + 1);
        }
        System.out.println(m);
    }
}