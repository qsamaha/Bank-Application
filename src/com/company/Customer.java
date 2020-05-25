package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String lastName;
    private ArrayList<Double> transactions;


    public Customer(String name, String lastName, Double transaction){
        this.name = name;
        this.lastName = lastName;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(transaction);
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public void depositAmount(Double deposit){
        this.transactions.add(new Double(deposit));
    }

    public void withdrawalAmount(Double withdrawal){
        this.transactions.add(new Double(withdrawal * -1));
    }

    public double accountTotal(){
        double sum = 0;
        for(double add : transactions){
            sum += add;
        }

        return sum;
    }

}
