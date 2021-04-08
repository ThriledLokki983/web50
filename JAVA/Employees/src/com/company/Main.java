package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee john = new Employee("John Nimoh", 40);
        Employee jane = new Employee("Jane Agyin", 21);
        Employee Mary = new Employee("Mary Osei", 19);
        Employee Gideon = new Employee("Gideon Nimoh-Agyin", 31);
        Employee red = new Employee("John Snow", 27);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(jane);
        employees.add(Gideon);
        employees.add(Mary);
        employees.add(red);

        printEmployeesByAge(employees, "======Employee over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "======Employee below 30", employee -> employee.getAge() < 30);
        printEmployeesByAge(employees, "======Employee Younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate intp = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(intp.test(10));
        int a = 20;
        System.out.println(intp.test(a+5));

        System.out.println(intp.and(lessThan100).test(50));
        System.out.println(intp.and(lessThan100).test(15));

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(50);
        for (int i = 0; i < 10; i++){
            //System.out.println(random.nextInt(20));
            System.out.println(randomSupplier.get());
        }


/*        System.out.println("=================Employees over 30: ");
       employees.forEach(employee -> {
           if (employee.getAge() > 30){
               System.out.println(employee.getName());
           }
       });

        System.out.println("=================== 30 and Younger");
        employees.forEach(employee -> {
            if (employee.getAge() <= 30){
                System.out.println(employee.getName());
            }
        });*/
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        for (Employee employee : employees){
            if (ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}
