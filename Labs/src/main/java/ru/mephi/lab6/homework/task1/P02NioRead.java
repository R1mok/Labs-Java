package ru.mephi.lab6.homework.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {

    public static void main(String[] args) throws IOException {
        try { // Create Try with Resources here

            System.out.println("\n=== Entire File ===");
            Path file = Paths.get("Labs/src/main/java/ru/mephi/lab6/homework/task1/hamlet.txt");
            Stream<String> lines = Files.lines(file);
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
