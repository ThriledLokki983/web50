package com.company;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Double> transaction;

    public Transactions(ArrayList<Double> transaction) {
        this.transaction = transaction;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public boolean createTransaction(Double number){
        this.transaction = transaction.add(number);
    }
}
