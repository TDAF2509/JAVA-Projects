package com.TDAF;

public class FlourPacker {
    public static boolean canPack(int bigCount,int smallCount,int goal){
        if(bigCount<0 ||smallCount<0 || goal<0||bigCount*5+smallCount<goal){
            System.out.println("false");
            return false;
        }for (int bigCounter=0;bigCounter<=bigCount;bigCounter++){
            for (int smallCounter=0;smallCounter<=smallCount;smallCounter++){
                if (bigCounter*5+smallCounter==goal){
                    System.out.println("true");
                    return true;
                }
            }
        }
        return false;
    }

}

