package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "G53", "G51", "I29", "N40",
                "N36", "B6", "071", "G49", "I17", "g64",
                "G50", "B12");

        List<String> gNumbers = new ArrayList<>();
        /* Stream source must not be changed  */
        bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumber = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatenate = Stream.concat(ioNumber, inNumberStream);
        System.out.println("====================================");
        System.out.println(concatenate
                .distinct()
                .peek(System.out::println)
                .count());

 /*       bingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
                //System.out.println(number.toUpperCase());
            }
        });
        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
        gNumbers.forEach((s) -> System.out.println(s));*/

        Employee john = new Employee("John Doe", 30);
        Employee jack = new Employee("Jack Smith", 29);
        Employee jane = new Employee("Jane Deer", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jack);
        hr.addEmployee(john);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("============================================ ");
        List<String> sortedNumber = bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add,/*Accumulator*/ ArrayList::addAll /*Combiner*/);
               // .collect(Collectors.toList());


        for (String s : sortedNumber){
            System.out.println(s);
        }

        System.out.println("============================================ ");
        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));


        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        System.out.println("============================================ ");



    }
}
