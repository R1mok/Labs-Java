package ru.mephi.lab3;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

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
                .filter(e -> Objects.equals(e.getDept(), "Developing"))
                .forEach(accountant::paySalary);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getAge() > 30 && Objects.equals(e.getDept(), "HR"))
                .forEach(accountant::payPremium);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getRole() == Role.MANAGER)
                .forEach(accountant::paySalary);
        System.out.println("====Next stream====");
        p1.stream()
                .filter(e -> e.getRole() == Role.STAFF)
                .forEach(accountant::payPremium);
        System.out.println("====Home work====");

        // Consumer выводит Role Employee
        System.out.println("====Consumer====");
        Consumer<Employee> roleConsumer = t ->
                System.out.println("First employee role is: " + t.getRole());

        roleConsumer.accept(p1.get(0));
        // Function возвращает номер телефона Employee
        System.out.println("====Function====");
        Function<Employee, String> numberFunction =
                Employee::getPhone;

        System.out.println("Number of first employee is: " + numberFunction.apply(p1.get(0)));
        // Supplier добавляет меня
        System.out.println("====Supplier====");
        Supplier<Employee> employeeSupplier =
                () -> new Employee.EmployeeBuilder()
                        .setGender(Gender.MALE)
                        .setPhone("88005553535")
                        .setGivenName("Anton")
                        .setSurName("Mikhalev")
                        .setAddress("Moskvorechie2k2")
                        .setAge(20)
                        .setRole(Role.STAFF)
                        .build();
        p1.add(employeeSupplier.get());
        p1.stream()
                .filter(e -> Objects.equals(e.getSurName(), "Mikhalev"))
                .forEach(employee -> System.out.println("My name is " + employee.getGivenName()));
        // BiPredicate проверяет является ли employee мужчиной|женщиной
        System.out.println("====BiPredicate====");
        BiPredicate<Employee, Gender> employeeGender =
                (t, s) -> t.getGender().equals(s);
        System.out.println("Is " + p1.get(0).getSurName() + " a " + p1.get(0).getGender().toString() + "?");
        System.out.println(employeeGender.test(p1.get(0), Gender.MALE));
    }

}
