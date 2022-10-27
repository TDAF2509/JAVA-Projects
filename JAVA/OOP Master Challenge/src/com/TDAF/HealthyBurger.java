package com.TDAF;

public class HealthyBurger extends Hamburger{
    private boolean onions;
    private boolean gherkin;

    public HealthyBurger(boolean onions, boolean gherkin, double price) {
        super("Brown Rye", "Chicken",price, "Healthy Burger");
        this.onions = onions;
        this.gherkin = gherkin;
    }

    public boolean isOnions() {
        setPrice(getPrice()+0.5);
        return onions;
    }

    public boolean isGherkin() {
        setPrice(getPrice()+0.5);
        return gherkin;
    }


}
