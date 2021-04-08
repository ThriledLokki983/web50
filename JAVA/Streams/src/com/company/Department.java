package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: Gideon Nimoh
 * Date: 4/8/21
 * Time: 8:52 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
