package com.TDAF;

import java.util.ArrayList;

public class BikeRecords {
    private ArrayList<Bicycle> bikeList = new ArrayList<Bicycle>();

    public ArrayList<Bicycle> getBikeList() {
        return bikeList;
    }

    public void setBikeList(ArrayList<Bicycle> bikeList) {
        this.bikeList = bikeList;
    }

    public void addToList(Bicycle toAdd){
        bikeList.add(toAdd);
    }

    public int returnList(){
        return bikeList.size();
    }

    public void printing(){
        for (int i=0 ; i<bikeList.size();i++){
            if (bikeList.get(i).getOnHire()){
                System.out.println(bikeList.get(i).getMakersName());
                System.out.println(bikeList.get(i).getModelName());
            }
        }
    }

    public void listSearch(String makersName,String modelName,int age){
        for (int i=0;i<bikeList.size();i++){
            if (makersName==bikeList.get(i).getMakersName() && modelName==bikeList.get(i).getModelName()){
                bikeList.get(i).setAge(age);
            }
        }
    }
}
