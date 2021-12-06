package ru.mephi.lab6.homework.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirFind {

    public static void main(String[] args) throws IOException{


        try { // Add try with resources

            System.out.println("\n=== Find all dirs ===");
            // Print out directory list here
            Path dir = Paths.get("Labs/src/main/java/ru/mephi/lab6/homework/task2");
            Stream<Path> files = Files.find(Paths.get("."), 5, (p, a) -> a.isDirectory());
            files.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
