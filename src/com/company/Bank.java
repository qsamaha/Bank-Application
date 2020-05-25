package com.company;

import java.util.ArrayList;


public class Bank {
    private ArrayList <Branch> branchList;
    private String bankName;

    public Bank(String bankName){
        this.bankName = bankName;
        this.branchList = new ArrayList<>();
    }

    public String getBankName(){
        return bankName;
    }

    public void printBranches(){
        for(Branch banks : branchList){
            System.out.println("Branches: " + banks.getBranchName());
        }
    }

    public boolean addBranch(String branchName){
        int position = findBranch(branchName);
        if(position >= 0){
            return false;
        }

        this.branchList.add(new Branch(branchName));
        return true;
    }

    public void printBranchCustomers(String branchName){
        int position = findBranch(branchName);
        if(position >= 0){
            System.out.println("Branch " + branchName + "'s customers are: ");
            this.branchList.get(position).printCustomers();
        }
    }

    public boolean addCustomers(String branchName, String name, String lastName, Double initialTransaction){
        int position = findBranch(branchName);
        if(position < 0){
            return false;
        }else if(!this.branchList.get(position).addCustomer(name, lastName, new Double (initialTransaction))){
            return false;
        }

        this.branchList.get(position).addCustomer(name, lastName, new Double(initialTransaction));
        return true;
    }

    public boolean addTransaction(String branchName, String name, String lastName, Double deposit){
        int position = findBranch(branchName);
        if(position < 0){
            return false;
        }else if(!this.branchList.get(position).addAmount(name, lastName, new Double (deposit))){
            return false;
        }



        return true;
    }

    public boolean withdrawalFromAccount(String branchName, String name, String lastName, Double withdrawal){
        int position = findBranch(branchName);
        if(position < 0){
            return false;
        }else if(!this.branchList.get(position).subtractAmount(name, lastName, new Double(withdrawal))){
            return false;
        }


        return true;
    }

    public double displayAccountTotal(String branchName, String name, String lastName){
        int position = findBranch(branchName);
        if(position < 0){
            return -1;
        }
        return this.branchList.get(position).getCustomerAccountTotal(name, lastName);
    }

    public int findBranch(String name){
        for(int i = 0; i < branchList.size(); i++){
            if(branchList.get(i).getBranchName().equalsIgnoreCase(name)){
                return i;
            }
        }

        return -1;
    }
}
