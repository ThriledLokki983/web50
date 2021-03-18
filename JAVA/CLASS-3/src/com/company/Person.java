package com.company;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getAge(){
        return this.age;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge(int age){
//        if(age < 0 || age > 100){
//            this.age = 0;
//        }else{
//            this.age = age;
//        }
        this.age = (age < 0 || age > 100) ? 0 : age;
    }

    public boolean isTeen(){
//        if(age > 12 && age < 20) {
//            return true;
//        }
//        return false;
        return(age > 12 && age < 20);
    }

    public String getFullName(){
        if(firstName == null || lastName == null) return "";
        if (firstName.isEmpty()) return lastName;
        if(lastName.isEmpty()) return firstName;
        return firstName + "" + lastName;

        //return (firstName.isEmpty() || lastName.isEmpty() ? "" : firstName.isEmpty() ? lastName : lastName.isEmpty() ? firstName : firstName + " " + lastName);
    }
}

