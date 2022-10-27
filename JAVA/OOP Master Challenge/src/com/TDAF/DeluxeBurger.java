package com.TDAF;

public class DeluxeBurger extends Hamburger{
    private String drink;
    private String chips;

    public DeluxeBurger(String drink, String chips,double price) {
        super("sesame", "Chuck Steak", price, "Deluxe Burger");
        this.drink = drink;
        this.chips = chips;
    }

    public String getDrink() {
        return drink;
    }

    public String getChips() {
        return chips;
    }


}
