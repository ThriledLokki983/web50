package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person person = new Person();
        person.setFirstName(" ");
        person.setLastName(" ");
        person.setAge(10);

        System.out.println("Full Name = " + person.getFullName());
        System.out.println("Teen = " + person.isTeen() );
        System.out.println("Age = " + person.getAge());

        person.setFirstName("John");
        person.setAge(18);
        System.out.println("Full Name = " + person.getFullName());
        System.out.println("Teen = " + person.isTeen());

        person.setLastName(" Smith");
        System.out.println("Full Name = " + person.getFullName());
    }
}
