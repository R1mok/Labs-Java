package ru.mephi.lab3;

public class Accountant {
    public void paySalary(Employee employee){
        System.out.println("Employee " + employee.getSurName() + " got 300$ salary");
    }

    public void payPremium(Employee employee){
        System.out.println("Employee " + employee.getSurName() + " got " + 300 * employee.getRole().getPercent() + "$ premium salary like " + employee.getRole());
    }
}