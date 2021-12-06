package ru.mephi.lab6;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class ClassWork {
    private File file;

    ClassWork(File file) {
        this.file = file;
    }

    public void getStringByValue(String str) throws FileNotFoundException {
        try {
            FileReader fis = new FileReader(file);
            BufferedReader reader = new BufferedReader(fis);
            Stream<String> lines = reader.lines();
            Object[] linesArray = lines.toArray();
            int i = 0;
            for (Object line : linesArray) {
                ++i;
                if (line.equals(str)) {
                    System.out.println("Line " + str + " was found. Number of line: " + i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getStringByNumber(int line) throws FileNotFoundException {
        String findLine = "";
        try {
            FileReader fis = new FileReader(file);
            BufferedReader reader = new BufferedReader(fis);
            int i = 0;
            while (findLine != null) {
                if (i == line) {
                    System.out.println(findLine);
                    break;
                }
                ++i;
                findLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void occurrances(String str) throws FileNotFoundException {
        try {
            FileReader fis = new FileReader(file);
            BufferedReader reader = new BufferedReader(fis);
            Stream<String> lines = reader.lines();
            System.out.println(lines.filter(e -> e.equals(str)).count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // first task
        File file1 = new File("Labs/src/main/java/ru/mephi/lab6/file1.txt");
        ClassWork work1 = new ClassWork(file1);
        work1.getStringByNumber(2);
        Scanner scanner = new Scanner(System.in);
        String curStr = scanner.next();
        work1.getStringByValue(curStr);
        work1.occurrances(curStr);

        // second task

        // serialize
        ArrayList<Item> items = new ArrayList<>(1);
        items.add(new Item(1, "milk", 2.3));
        ShoppingCart sc = new ShoppingCart(1, 2, 30, items);
        sc.writeObject();
        try {

            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        // deserialize
        ShoppingCart sc1 = new ShoppingCart();
        sc1.readObject();
        System.out.println(sc1.getCurTime());
        System.out.println(LocalDateTime.now());
    }
}
