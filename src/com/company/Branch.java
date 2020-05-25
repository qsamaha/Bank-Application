package com.company;

import java.util.ArrayList;

public class Branch {
   private final ArrayList <Customer> CUSTOMER_ARRAYLIST;
   private String branchName;

   public Branch(String branchName){
       this.branchName = branchName;
       this.CUSTOMER_ARRAYLIST = new ArrayList<>();
   }


    public String getBranchName(){
       return branchName;
    }

    public void printCustomers(){
        for(int i = 0; i < CUSTOMER_ARRAYLIST.size(); i++){
            System.out.println("Customer #" + (i + 1) + " First Name: " + CUSTOMER_ARRAYLIST.get(i).getName() + " Customer Last Name: " + CUSTOMER_ARRAYLIST.get(i).getLastName());
        }
    }

    public boolean addCustomer(String name, String lastName, Double initialTransaction){
        if(findCustomer(name, lastName) >= 0){
            return false;
        }

        this.CUSTOMER_ARRAYLIST.add(new Customer(name, lastName, new Double(initialTransaction)));
        return true;
    }

    public boolean addAmount(String name, String lastName, double deposit){
       int position = findCustomer(name, lastName);
       if(position < 0){
            return false;
        }else if(deposit <= 0){
            return false;
        }


        this.CUSTOMER_ARRAYLIST.get(position).depositAmount(deposit);
        return true;
    }

    public boolean subtractAmount(String name, String lastName, double withdrawal){
       int position = findCustomer(name, lastName);
       if(position < 0){
            return false;
        }else if(this.CUSTOMER_ARRAYLIST.get(position).accountTotal() < withdrawal){
            return false;
        }

        this.CUSTOMER_ARRAYLIST.get(position).withdrawalAmount(withdrawal);
        return true;
    }

    public double getCustomerAccountTotal(String name, String lastName){
       int position = findCustomer(name, lastName);
       if(position < 0){
           System.out.println("Customer not found");
           return -1;
       }else {
           return this.CUSTOMER_ARRAYLIST.get(position).accountTotal();
       }
    }

    public int findCustomer(String name, String lastName){
        for(int i = 0; i < CUSTOMER_ARRAYLIST.size(); i++){
            if (CUSTOMER_ARRAYLIST.get(i).getName().equalsIgnoreCase(name) &&
                    CUSTOMER_ARRAYLIST.get(i).getLastName().equalsIgnoreCase(lastName)){
                return i;
            }
        }

        return -1;
    }

    public int findCustomer(Customer Customer){
        return CUSTOMER_ARRAYLIST.indexOf(Customer);
    }

}
