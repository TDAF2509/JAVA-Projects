package com.TDAF;

public class Main {

    public static void main(String[] args) {
	Hamburger hamburger = new Hamburger("plain","Beef",5,"Basic Burger");
	DeluxeBurger deluxeBurger = new DeluxeBurger("Fanta","Fries",10);
	HealthyBurger healthyBurger = new HealthyBurger(true, true,7);

	System.out.println(hamburger.getName()+"= £"+hamburger.getPrice()+" with no add ons");
	hamburger.getBacon();
	hamburger.getCheese();
	hamburger.getLettuce();
	hamburger.getTomato();
	System.out.println(hamburger.getName()+"= £"+hamburger.getPrice()+" with all the add ons");


	healthyBurger.getCheese();
	healthyBurger.getBacon();
	healthyBurger.getLettuce();
	healthyBurger.getTomato();
	healthyBurger.isGherkin();
	healthyBurger.isOnions();
	System.out.println(healthyBurger.getName()+"= £"+healthyBurger.getPrice()+" with all the add ons");


	deluxeBurger.getChips();
	deluxeBurger.getDrink();
	System.out.println(deluxeBurger.getName()+"= £"+deluxeBurger.getPrice()+" with all the add ons");
	}
}
