package ru.mephi.lab3;

import java.util.*;

public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int code;
    private int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", gender= " + gender +
                ", role = " + role +
                ", dept='" + dept + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code=" + code +
                ", salary=" + salary + '\'' +
                '}';
    }

    private Employee() {
    }

    public Employee(EmployeeBuilder employeeBuilder) {
        if (employeeBuilder == null) {
            throw new IllegalArgumentException("Provide employee builder to build employee object");
        }
        if (employeeBuilder.givenName == null && employeeBuilder.surName == null) {
            throw new IllegalArgumentException("Please provide employee name.");
        }
        this.givenName = employeeBuilder.givenName;
        this.surName = employeeBuilder.surName;
        this.age = employeeBuilder.age;
        this.gender = employeeBuilder.gender;
        this.role = employeeBuilder.role;
        this.dept = employeeBuilder.dept;
        this.eMail = employeeBuilder.eMail;
        this.phone = employeeBuilder.phone;
        this.address = employeeBuilder.address;
        this.city = employeeBuilder.city;
        this.state = employeeBuilder.state;
        this.code = employeeBuilder.code;
        this.salary = employeeBuilder.salary;
    }

    public static class EmployeeBuilder {
        protected String givenName;
        protected String surName;
        protected int age = 20;
        protected Gender gender = Gender.MALE;
        protected Role role = Role.STAFF;
        protected String dept = "";
        protected String eMail = "";
        protected String phone = "";
        protected String address = "";
        protected String city = "Moscow";
        protected String state = "Moscow";
        protected int code = 777;
        protected int salary = 0;

        public EmployeeBuilder() {
            super();
        }

        public EmployeeBuilder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public EmployeeBuilder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public EmployeeBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder setRole(Role role) {
            this.role = role;
            return this;
        }

        public EmployeeBuilder setDept(String dept) {
            this.dept = dept;
            return this;
        }

        public EmployeeBuilder setEMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public EmployeeBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public EmployeeBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public EmployeeBuilder setCode(int code) {
            this.code = code;
            return this;
        }

        public Employee build() {
            Employee emp = null;
            if (givenName != null || surName != null) {
                emp = new Employee(this);
            } else {
                System.out.println("Can't build object Employee");
            }
            return emp;
        }
    }

    public String getGivenName() {
        return givenName;
    }

    public Role getRole() {
        return role;
    }

    public String getSurName() {
        return surName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {return age;}

    public int getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDept() {
        return dept;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getState() {
        return state;
    }

    public int getSalary() { return salary; }

    public void setState(String state) {
        this.state = state;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    public static List<Employee> createShortList() {
        List<Employee> list = new ArrayList<>();
        list.add(
                new EmployeeBuilder()
                        .setAge(26)
                        .setGivenName("Anton")
                        .setSurName("Popov")
                        .setRole(Role.STAFF)
                        .setPhone("88334412323")
                        .setDept("Developing")
                        .setSalary(300)
                        .build()
        );
        list.add(
                new EmployeeBuilder()
                        .setAge(35)
                        .setGivenName("Alexandra")
                        .setSurName("Romanova")
                        .setAddress("Royal Family 32")
                        .setPhone("89459993321")
                        .setGender(Gender.FEMALE)
                        .setEMail("royalfamily@gmail.com")
                        .setRole(Role.EXECUTIVE)
                        .setDept("HR")
                        .setSalary(500)
                        .build()
        );
        list.add(
                new EmployeeBuilder()
                        .setAge(21)
                        .setGivenName("Andrew")
                        .setSurName("Dimanov")
                        .setAddress("Koshkina 11 k 1")
                        .setPhone("88005553535")
                        .setRole(Role.STAFF)
                        .setDept("Developing")
                        .setSalary(1000)
                        .build()
        );
        list.add(
                new EmployeeBuilder()
                        .setAge(28)
                        .setGivenName("Maria")
                        .setSurName("Petrova")
                        .setGender(Gender.FEMALE)
                        .setPhone("88003334456")
                        .setRole(Role.EXECUTIVE)
                        .setCity("Los Angeles")
                        .setState("California")
                        .setCode(129)
                        .setSalary(250)
                        .build()
        );
        list.add(
                new EmployeeBuilder()
                        .setAge(26)
                        .setGivenName("Dmitriy")
                        .setSurName("Komarov")
                        .setAddress("Pobedy 43")
                        .setPhone("89123228334")
                        .setRole(Role.MANAGER)
                        .setDept("PR")
                        .setSalary(300)
                        .build()
        );
        list.add(
                new EmployeeBuilder()
                        .setAge(23)
                        .setGivenName("Alisher")
                        .setSurName("Morgenshtern")
                        .setAddress("Kremlin 1")
                        .setPhone("86666666666")
                        .setRole(Role.EXECUTIVE)
                        .setEMail("morningstar@gmail.com")
                        .setDept("PR")
                        .build()
        );
        list.add(
                new EmployeeBuilder()
                        .setGivenName("Pirat")
                        .setSurName("Morey")
                        .setAddress("Karibskaya 23")
                        .setPhone("81337442334")
                        .setEMail("newpirat@gmail.com")
                        .setRole(Role.MANAGER)
                        .build()
        );
        return list;
    }

    public static void main(String[] args) {
        Employee Person1 = new EmployeeBuilder().setGivenName("Andrew").setGender(Gender.MALE).build();
        System.out.println(Person1);
    }
}