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

    public void setTransaction(ArrayList<Double> transaction) {
        this.transaction = transaction;
    }
}
