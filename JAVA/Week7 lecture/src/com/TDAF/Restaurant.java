package com.TDAF;

public class Restaurant {
    private String name;
    private int numberOfTables;
    private int[] tables;
    private static int numberOfRestaurants = 0;

    static {System.out.println("Welcome");}

    public Restaurant(String name, int numberOfTables, int[] tables) {
        this.name = name;
        this.numberOfTables = numberOfTables;
        this.tables = tables;
        updateNumberOfResteraunts();
    }



//    {
//        System.out.println("Welcome to the new Restaurant: "+name);
//    }

    public void updateSeats(int seats){
        for (int i = 0;i<tables.length;i++){
            tables[i] += seats;
        }
    }

    private static int updateNumberOfResteraunts(){
        return numberOfRestaurants++;

    }

    public static int getNumberOfRestaurants() {
        return numberOfRestaurants;
    }

    public static void setNumberOfRestaurants(int numberOfRestaurants) {
        Restaurant.numberOfRestaurants = numberOfRestaurants;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public int[] getTables() {
        return tables;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public void setTables(int[] tables) {
        this.tables = tables;
    }
}
