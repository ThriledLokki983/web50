package com.company;

import Model.DataSource;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Cannot open database!");
            return;
        }else{
            System.out.println("Database is now ACTIVE!");
        }
        dataSource.close();
    }
}
