package com.company;

import java.util.*;

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

        employees.forEach(employee ->{
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

/*for (Employee employee : employees){
    System.out.println(employee.getName());
    System.out.println(employee.getAge());
   // new Thread(() -> System.out.println(employee.getAge())).start();
}*/

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

    // Collections.sort(employees, Comparator.comparing(employee1 -> employee1.getName()));

/*        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }*//*        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        },
        employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);*//*    Collections.sort(employees, new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });*//* The Lambda Function *//*        UpperConcat uc = (s1, s2) -> {
                String result = s1.toUpperCase() + " " + s2.toUpperCase(); *//* The code block is need when more than one statement is needed for the lambda expression*//*
                return result;
        };
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
        */

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

class AnotherClass{
    public String doSomething(){
        int i = 0;
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression class is = " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };

        System.out.println("The Anonymous class's name is = " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String 1", "String 2");
/*        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    return s1.toUpperCase() + " " + s2.toUpperCase();
                }
            };
            System.out.println("The Another class = " + getClass().getSimpleName());

            i++;
            System.out.println("I = " + i);
            return Main.doStringStuff(uc, "String 1", "String 2");
        }*//*   UpperConcat uc = (s1, s2) -> {
           System.out.println("The Lambda expression class = " + getClass().getSimpleName());
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };*//*System.out.println("The Another Class class's name = " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The Anonymous Class class's name = " + getClass().getSimpleName());
                return s1.toUpperCase() + " " + (s2.toUpperCase());
            }
        }, "String 1", "String 2");*/
    }

    public void printValue(){
        int number = 25;
        Runnable e = () -> {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException f){
                f.printStackTrace();
            }
            System.out.println("The value is " + number);
        };
        new Thread(e).start();
    }
}
