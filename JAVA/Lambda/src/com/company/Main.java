package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*new Thread(new CodeToRun()).start();*/
        Employee john = new Employee("John Nimoh", 40);
        Employee jane = new Employee("Jane Agyin", 21);
        Employee Mary = new Employee("Mary Osei", 19);
        Employee Gideon = new Employee("Gideon Nimoh-Agyin", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(jane);
        employees.add(Gideon);
        employees.add(Mary);

/*    Collections.sort(employees, new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });*/

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        // Collections.sort(employees, Comparator.comparing(employee1 -> employee1.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        },
        employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);


    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/*class CodeToRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Coming through from the Runnable");
    }
}*/

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}
