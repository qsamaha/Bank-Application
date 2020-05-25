package com.company;

import javax.sound.midi.Soundbank;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Bank bank = new Bank("Qutada's Big Bank");
    public static void main(String[] args) {
        startingUp();
        printInstructions();
        System.out.println("Welcome to " + bank.getBankName());
        boolean flag = true;
        while(flag){
            System.out.println("Enter Choice (Press 0 for instructions)");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printBranches();
                    break;
                case 2:
                    addBranch();
                    break;
                case 3:
                    showCustomersInBranch();
                    break;
                case 4:
                    addCustomersToBranch();
                    break;
                case 5:
                    depositToCustomerInBranch();
                    break;
                case 6:
                    withdrawalFromCustomerInBranch();
                    break;
                case 7:
                    flag = false;
                default:
                    System.out.println("Invalid Entry, Try Again");
            }

        }
    }

    public static void startingUp(){
        System.out.println("Applicatoin is starting up.....");
    }

    public static void printInstructions(){
        System.out.println("0 -> to print instructions");
        System.out.println("1 -> to print branch");
        System.out.println("2 -> to add list of branches");
        System.out.println("3 -> to show customers in a particular branch");
        System.out.println("4 -> to add a customer to a particular branch");
        System.out.println("5 -> to deposit money into a customer's account");
        System.out.println("6 -> to withdrawal money from a customer's account");
        System.out.println("7 -> to quit application");
    }

    public static void printBranches(){
        bank.printBranches();
    }

    public static void addBranch(){
        System.out.println("Enter name of Branch: ");
        String branchName = scan.nextLine();
        if(bank.addBranch(branchName)){
            System.out.println("Branch has been successfully added");
        }else{
            System.out.println("Branch could not be added");
        }
    }

    public static void showCustomersInBranch(){
        System.out.println("Enter Branch Name: ");
        String branchName = scan.nextLine();
        bank.printBranchCustomers(branchName);
    }

    public static void addCustomersToBranch(){
        System.out.println("Enter name of branch you are adding a customer to: ");
        String branchName = scan.nextLine();
        if(bank.findBranch(branchName) < 0){
            System.out.println("Branch is not in system, Cannot add customer");
            return;
        }
        System.out.println("Enter first name of customer: ");
        String firstName = scan.nextLine();
        System.out.println("Enter last name of customer: ");
        String lastName = scan.nextLine();
        System.out.println("Enter initial deposit amount: ");
        double initialDeposit = scan.nextDouble();
        scan.nextLine();
        if(bank.addCustomers(branchName, firstName, lastName, initialDeposit)){
            System.out.println("Customer " + firstName + " " + lastName + " has been added to " +
                    branchName + " with an initial deposit amount of " + initialDeposit);
        }else{
            System.out.println("Customer could not be added");
        }

        System.out.println("Account Total Balance: ");
        System.out.println(bank.displayAccountTotal(branchName, firstName, lastName));
    }

    public static void depositToCustomerInBranch(){
        System.out.println("Enter name of branch: ");
        String branchName = scan.nextLine();
        if(bank.findBranch(branchName) < 0){
            System.out.println("Branch is not in system, Cannot add customer");
            return;
        }
        System.out.println("Enter first name of customer: ");
        String firstName = scan.nextLine();
        System.out.println("Enter last name of customer: ");
        String lastName = scan.nextLine();
        System.out.println("Enter deposit amount: ");
        double deposit = scan.nextDouble();
        scan.nextLine();

        if(bank.addTransaction(branchName,firstName,lastName,deposit)){
            System.out.println("Successfully deposited $" + deposit + " to " + firstName + "'s account.");
            System.out.println("Branch: " + branchName);
        }else {
            System.out.println("Was not able to deposit amount");
        }

        System.out.println("Account Total Balance: ");
        System.out.println(bank.displayAccountTotal(branchName, firstName, lastName));
    }

    public static void withdrawalFromCustomerInBranch(){
        System.out.println("Enter name of branch: ");
        String branchName = scan.nextLine();
        if(bank.findBranch(branchName) < 0){
            System.out.println("Branch is not in system, Cannot add customer");
            return;
        }
        System.out.println("Enter first name of customer: ");
        String firstName = scan.nextLine();
        System.out.println("Enter last name of customer: ");
        String lastName = scan.nextLine();
        System.out.println("Enter withdrawal amount: ");
        double withdrawal = scan.nextDouble();
        scan.nextLine();

        if(bank.withdrawalFromAccount(branchName, firstName, lastName, withdrawal)){
            System.out.println("Successfully withdrew $" + withdrawal + " from " + firstName + "'s account");
        }else{
            System.out.println("Insufficient Funds");
        }

        System.out.println("Account Total Balance: ");
        System.out.println(bank.displayAccountTotal(branchName, firstName, lastName));
    }
}
