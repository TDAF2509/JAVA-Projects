package com.TDAF;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount= new BankAccount("123",1000000,"Tayo","Tdaf2509@hotmail.co.uk","0772235639");


        System.out.println(bankAccount.getAccountNumber());
        System.out.println("£"+bankAccount.getBalance());
        System.out.println(bankAccount.getCustomerName());
        System.out.println(bankAccount.getEmail());
        System.out.println(bankAccount.getPhoneNumber());

        //Constructor without parameters
        //bankAccount.setAccountNumber("1");
        //bankAccount.setBalance(1000000);
        //bankAccount.setCustomerName("Sandra Folkes");
        //bankAccount.setEmail("S.Folkes@hotmail.com");
        //bankAccount.setPhoneNumber("07961199543");

        //System.out.println("Account Number = "+bankAccount.getAccountNumber());
        //System.out.println("Balance = "+bankAccount.getBalance());
        //System.out.println("Customer Name = "+bankAccount.getCustomerName());
        //System.out.println("Email = "+bankAccount.getEmail());
        //System.out.println("Phone Number = "+bankAccount.getPhoneNumber());

        //bankAccount.depositFunds(500000);
        //System.out.println("New Balance = "+bankAccount.getBalance());

        //bankAccount.withdrawFunds(20000);
        //System.out.println("New Balance = "+bankAccount.getBalance());

        BankAccount account= new BankAccount("TDAF","tdaf2509@hotmail.com","12345");
        System.out.println("name "+account.getCustomerName()+" phone number "+account.getPhoneNumber());
    }

}
