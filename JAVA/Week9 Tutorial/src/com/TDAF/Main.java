package com.TDAF;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ChristmasGift gift1 = new ChristmasGift("Fifa 20","A",40);
        ChristmasGift gift2 = new ChristmasGift("Mortal Kombat 11","B",35);
        ChristmasGift gift3 = new ChristmasGift("Spider-man PS4","C",50);
        MyChristmasList mylist = new MyChristmasList();
        mylist.gift(gift1);
        mylist.gift(gift2);
        mylist.gift(gift3);

        printList(mylist);

    }

    public static void printList(MyChristmasList list) {
        for (int i=0; i<list.getMyList().size();i++){
            System.out.println("Gift name = "+list.getMyList().get(i).getName()+"\n"+
                    "Recipient = "+list.getMyList().get(i).getRecipient());
        }
    }
}
