package com.TDAF;

public class Main {

    public static Shop shop = new Shop("Shop name",-20,new int[20]);
    public static Shop shop2 = new Shop();
    public static Buyer buyer = new Buyer(Shop,new int[5]);

    public static void main(String[] args) {
        System.out.println(shop.getName());
        System.out.println(shop.getNumberOfArticles());
        System.out.println(shop.getArticles().length);

        System.out.println(shop2.getName());
        System.out.println(shop2.getNumberOfArticles());
        System.out.println(shop2.getArticles().length);

    }

    public boolean trueorFalse() {
        if (shop.getArticles().length==shop.getNumberOfArticles()){
            return true;
        }
        return false;
    }


}
