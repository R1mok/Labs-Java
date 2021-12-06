package ru.mephi.lab6.homework.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class P03NioReadAll {

    public static void main(String[] args) {

        List<String> fileArr;
        Path file = Paths.get("Labs/src/main/java/ru/mephi/lab6/homework/task1/hamlet.txt");

        try {
            // Read file into array here
            fileArr = Files.readAllLines(file);
            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            fileArr.stream().filter(v -> v.contains("Ros. ")).forEach(System.out::println);

            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            fileArr.stream().filter(v -> v.contains("Guil. ")).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
