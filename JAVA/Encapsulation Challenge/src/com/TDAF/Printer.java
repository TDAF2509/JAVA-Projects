package com.TDAF;

public class Printer {
    private int tonerLVL;
    private int numberOfPages;
    private boolean duplex;

    public Printer(int tonerLVL, boolean duplex) {
        if (tonerLVL>=0 && tonerLVL<=100){
            this.tonerLVL = tonerLVL;
        }else{
            this.tonerLVL=-1;
        }
        this.numberOfPages = 0;
        this.duplex = duplex;
    }

    public int fillToner(int fill){
        if (fill>0 && fill<=100){
            // Checks the toner level and uses selection based on the level
            if (this.tonerLVL+fill==100){
                System.out.println("Toner 100% filled");
                this.tonerLVL = this.tonerLVL +fill;
            }else if (this.tonerLVL+fill >100){
                System.out.println("Toner percentage cannot be greater that 100");
            }else{
                this.tonerLVL = this.tonerLVL +fill;
            }
        }else{
            return -1;
        }
        return tonerLVL;
    }

    public int printing(int pages){
        System.out.println("Preparing to print...");
        int sheets = pages;

        //Checks the boolean "duplex" and uses selection upon whether its true or false
        if (this.duplex&&pages>1){
        // When duplexing the number of sheets used are halved and their remainder of 2 is added
        // If the number of sheets was even then the remainder would be 0
        // If the number of sheets was odd then the remainder would be 1
        // This is done because you cannot have 0.5 of a sheet of paper
            sheets = (pages/2)+(pages%2);
            System.out.println("Printing in duplex mode...");
        }
        this.numberOfPages += sheets;
        //Checks toner level and if printing can be done with the amount left
        if (tonerLVL-pages<0 || tonerLVL<0){
            System.out.println("Printing Cancelled. Please fill up the toner.");
        }else{
            System.out.println("Printing "+pages+" pages on "+sheets+" sheets of paper");
            this.tonerLVL -= numberOfPages;
            this.numberOfPages = 0;
        }
        return numberOfPages;
    }



    public int getTonerLVL() {
        return tonerLVL;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
