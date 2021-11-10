package ru.mephi.lab4;

import ru.mephi.lab3.Employee;
import ru.mephi.lab3.Gender;
import ru.mephi.lab3.Role;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> p1 = Employee.createShortList();
        // map 1 - вывод всех телефонов с "+" в начале
        System.out.println("====map====");
        Stream<String> p2 = p1.stream().map(e -> "+" + e.getPhone());
        p2.forEach(System.out::println);
        System.out.println("================");
        // map 2 - вывод всех зарплат с добавлением $ в начале
        p2 = p1.stream().map(e -> e.getSalary() + "$");
        p2.forEach(System.out::println);
        // findFirst 1 - находим первого человека, которому больше 30 и выводим его фамилию и возраст
        System.out.println("====findFirst====");
        Employee person1 = p1.stream().filter(e -> e.getAge() >= 30).findFirst().get();
        System.out.println(person1.getSurName() + ": " + person1.getAge());
        // findFirst 2 - находим первого человека, у которого заплата больше 300 и выводим его фамилию и зарплату
        System.out.println("================");
        Employee person2 = p1.stream().filter(e -> e.getSalary() > 300).findFirst().get();
        System.out.println(person2.getSurName() + ": " + person2.getSalary());
        // max 1 - находим самого старого человека и выводим его фамилию и возраст
        System.out.println("====max====");
        Comparator<Employee> comparator1 = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        Comparator<Employee> comparator2 = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getSalary(), o2.getSalary());
            }
        };
        Employee person3 = p1.stream().max(comparator1).get();
        System.out.println(person3.getSurName() + ": " + person3.getAge());
        // max 2 - находим человека с самой большой зарплатой и выводим его фамилию и зарплату
        System.out.println("================");
        Employee person4 = p1.stream().max(comparator2).get();
        System.out.println(person4.getSurName() + ": " + person4.getSalary());
        // min 1 - находим самого младшего человека и выводим его фамилию и возраст
        System.out.println("====min====");
        Employee person5 = p1.stream().min(comparator1).get();
        System.out.println(person5.getSurName() + ": " + person5.getAge());
        System.out.println("================");
        // min 2 - находим человека с самой маленькой зарплатой среди EXECUTIVE и выводим его фамилию и зарплату
        Employee person6 = p1.stream().filter(e -> e.getRole().equals(Role.EXECUTIVE)).min(comparator2).get();
        System.out.println(person6.getSurName() + ": " + person6.getSalary());
        // peek 1 - для всех STAFF делаем Область MO
        System.out.println("====peek====");
        p1.stream().filter(e -> e.getRole().equals(Role.STAFF)).peek(e -> e.setState("MO")).forEach(System.out::println);
        System.out.println("================");
        // peek 2 - для всех Manager увеличиваем зп на 100
        p1.stream().filter(e -> e.getRole().equals(Role.MANAGER)).peek(e -> e.setSalary(e.getSalary() + 100)).forEach(System.out::println);
        // average 1 - для всех STAFF вывести среднюю зарплату
        System.out.println("====average====");
        System.out.println(p1.stream().filter(e -> e.getRole().equals(Role.STAFF)).mapToLong(e -> e.getSalary()).average().getAsDouble());
        System.out.println("================");
        // average 2 - сравнить среднюю зарплату женщин со средней зарплатой мужчин
        double averageMALE = p1.stream().filter(e -> e.getGender().equals(Gender.MALE)).mapToLong(e -> e.getSalary()).average().getAsDouble();
        double averageFEMALE = p1.stream().filter(e -> e.getGender().equals(Gender.FEMALE)).mapToLong(e -> e.getSalary()).average().getAsDouble();
        if (averageFEMALE > averageMALE){
            System.out.println("FEMALE: " + averageFEMALE);
        } else {
            System.out.println("MALE: " + averageMALE);
        }
        System.out.println("====sum====");
        // sum 1 - сумма зарплаты для MANAGER
        System.out.println(p1.stream().filter(e -> e.getRole().equals(Role.MANAGER)).mapToLong(Employee::getSalary).sum());
        System.out.println("================");
        // sum 2 - сумма зарплаты для мужчин
        System.out.println(p1.stream().filter(e -> e.getGender().equals(Gender.MALE)).mapToLong(Employee::getSalary).sum());
    }
}
