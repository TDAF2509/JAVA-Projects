package com.TDAF;

import java.util.ArrayList;
import java.util.Arrays;

public class MyChristmasList {
    private ArrayList<ChristmasGift> myList;

    public MyChristmasList() {
        myList= new ArrayList<ChristmasGift>();

    }

    public ArrayList<ChristmasGift> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<ChristmasGift> myList) {
        this.myList = myList;
    }

    public void gift(ChristmasGift gifts) {
        myList.add(gifts);
    }
}
