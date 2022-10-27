package com.TDAF;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant("Java bean ",8,new int[]{1,2,3,4,5,6,7,8});
        System.out.println("name = "+restaurant1.getName());
        restaurant1.setName("Java beanS");
        System.out.println("name = "+restaurant1.getName());
        System.out.println("Number of Restaurants = "+Restaurant.getNumberOfRestaurants());
        restaurant1.updateSeats(5);

        Restaurant restaurant2 = new Restaurant("Java bean",8,new int[]{1,2,3,4,5,6,7,8});
        Restaurant restaurant3 = new Restaurant("Java bean",8,new int[]{1,2,3,4,5,6,7,8});
        System.out.println("Number of Restaurants = "+Restaurant.getNumberOfRestaurants());
    }
}
