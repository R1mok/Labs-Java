package ru.mephi.lab6.homework.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
    public static void main(String[] args) throws IOException {

        try { // Add Try with resources here

            System.out.println("\n=== Dir list ===");
            // Print directory list here
            Stream<Path> files = Files.list(Paths.get("."));
            files.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
