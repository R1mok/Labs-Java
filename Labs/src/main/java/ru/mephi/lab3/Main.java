package ru.mephi.lab3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> p1 = Employee.createShortList();
        Accountant accountant = new Accountant();
        //System.out.println(p1);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getGender() == Gender.FEMALE)
                .forEach(accountant::payPremium);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getDept() == "Developing")
                .forEach(accountant::paySalary);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getAge() > 30 && e.getDept() == "HR")
                .forEach(accountant::payPremium);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getRole() == Role.MANAGER)
                .forEach(accountant::paySalary);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getRole() == Role.STAFF)
                .forEach(accountant::payPremium);
    }
}
