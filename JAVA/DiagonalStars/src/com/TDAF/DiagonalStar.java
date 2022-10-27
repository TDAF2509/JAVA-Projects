package com.TDAF;

public class DiagonalStar {
    public static void printSquareStar(int number) {
        int row=1;
        int column=1;
        if (number<5){
            System.out.println("Invalid Value");
        }else{
            while (column!=(number+1) && row!=(number+1)){
                while ((column==1 || row==1 || column==number || row==number || column==row || column==((number+1)-row))&& column<(number+1)){
                    System.out.print("*");
                    column++;
                }if (column>(number+1)){
                    System.out.println();
                    column=1;
                    row++;
                }else{
                    System.out.print(" ");
                    column++;
                    if(column==(number+1)){
                        column++;
                    }
                }
            }
        }
    }
    public static void printSquareStar2(int number){
        if((number <= 0) || (number < 5)){
            System.out.println("Invalid Value");
        }
        int rowCount = 0;
        int currentRow;
        for(int i = 1; i <= number; i++){
            for(int j = 1; j <= number; j++){
                if(number >= 5){
                    rowCount = number;
                    currentRow = i;
                    if((i == 1) || (i == number) || (j == 1) || (j == number)){
                        System.out.print("*");
                    } else if(i == j ){
                        System.out.print("*");
                    }else if(j == ((rowCount - currentRow) + 1)){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
