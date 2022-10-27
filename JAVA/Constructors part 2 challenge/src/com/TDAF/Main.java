package com.TDAF;

public class Main {

    public static void main(String[] args) {
	VipCustomer vip1= new VipCustomer();
	System.out.println("name "+vip1.getName());

	VipCustomer vip2 = new VipCustomer("Tayo",25000);
	System.out.println("name "+vip2.getName());

	VipCustomer vip3 = new VipCustomer("Goku", 10,"Goku@email");
        System.out.println("name "+vip3.getName());
        System.out.println("email "+vip3.getEmail());

    }
}
