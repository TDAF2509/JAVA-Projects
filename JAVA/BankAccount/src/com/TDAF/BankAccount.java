package com.TDAF;

import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    //This is a constructor
    // only called once
    //but can have more than one constructor
    public BankAccount(){
        this("1010",600,"Name","Email","Number");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String accountNumber,double balance,String customerName
            ,String email,String phoneNumber){
        System.out.println("Bank Account constructor with parameters called");
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.customerName=customerName;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public BankAccount(String customerName,String email,String phoneNumber){
        this("54321",2509,customerName,email,phoneNumber);
    }

    //Creating Setters and getters for the instances above
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void depositFunds(double deposit){
        System.out.println("Depositing £"+deposit+" into the account");
        this.balance+=deposit;
    }

    public void withdrawFunds(double withdraw){
        if (balance-withdraw>=0){
            System.out.println("Withdrawing £"+withdraw+" from the account");
            this.balance-=withdraw;
        }else {
            System.out.println("Withdrawal too great");
        }
    }
}
