package com.TDAF;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Bicycle bicycle1 = new Bicycle("Specialized","Roubaix",4);
        Bicycle bicycle2 = new Bicycle("Trek","Domane",3);
        Bicycle bicycle3 = new Bicycle("Giant","Avail",2);
        bicycle1.setOnHire(true);
        bicycle2.setOnHire(true);
        System.out.println(bicycle1.getMakersName());
        System.out.println(bicycle1.getModelName());

        BikeRecords bikeRecords = new BikeRecords();
        bikeRecords.addToList(bicycle1);
        bikeRecords.addToList(bicycle2);
        bikeRecords.addToList(bicycle3);

        bikeRecords.returnList();
        bikeRecords.printing();

        for (Map.Entry<Integer, Bicycle> entry : makeMap(bikeRecords).entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getMakersName() +
                    ", " + entry.getValue().getModelName());
        }
    }

    public static HashMap<Integer, Bicycle> makeMap(BikeRecords bikeRecords){
        HashMap<Integer, Bicycle> bikeMap = new HashMap<>();
        int count = 0;
        for (Bicycle bicycle : bikeRecords.getBikeList()){
            bikeMap.put(++count, bicycle);
        }
        return bikeMap;
    }
}
