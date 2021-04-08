package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 4/8/21
 * Time: 7:15 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Employee{
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
