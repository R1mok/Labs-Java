package ru.mephi.lab6.homework.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class P04NioReadAll {
    public static void main(String[] args) {

        Path file = Paths.get("Labs/src/main/java/ru/mephi/lab6/homework/task1/hamlet.txt");
        List<String> fileArr;
        try {
            // Read fileinto array here
            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Lord Count ===");
            long wordCount = 0; // Replace with your pipeline
            wordCount = fileArr.stream().filter(v -> v.contains("lord") || v.contains("Lord")).count();
            System.out.println("Word count: " + wordCount);

            System.out.println("\n=== Prison Count ===");
            wordCount = fileArr.stream().filter(v -> v.contains("prison") || v.contains("Prison")).count();

            System.out.println("Word count: " + wordCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
