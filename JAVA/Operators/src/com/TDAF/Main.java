package com.TDAF;

public class Main {

    public static void main(String[] args) {
        int result = 1 + 2;
        System.out.println("1+2 ="+result);

        int previousResult = result;
        result=result-1;
        System.out.println(previousResult + "-1="+result);

        previousResult = result;
        result=result*10;
        System.out.println(previousResult + "*10="+result);

        previousResult = result;
        result=result/5;
        System.out.println(previousResult + "/5="+result);

        //Returns the remainder of 4 divided by 3
        result= result %3;
        System.out.println(result+"%3 = " +result);

        // equal to saying result=result+1
        result++;
        System.out.println("the result is now " + result);

        // equal to saying result=result-1
        result--;
        System.out.println("result is now " +result);

        // equal to saying result=result+2
        result +=2;
        System.out.println("result  is now" +result);

        // equal to saying result=result*10
        result*=10;
        System.out.println("result is now " + result);

        // equal to saying reult=result-10
        result -=10;
        System.out.println("result is now " + result);

        //equal to saying result=result/10
        result/=10;
        System.out.println("result is now"  + result);

        // single equals is an assignmet
        // double equals tests the statement
        // much like python
        boolean isAlien=false;
        if (isAlien==false)// double negative
            System.out.println("not an alien");

        int topScore =100;
        if (topScore== 100)
            System.out.println("you got the high score");

        topScore =80;
        if (topScore >= 100)
            System.out.println("you got the high score");

        // && is eqaul to saying and
        int secondTopScore = 80;
        if ((topScore > secondTopScore) && (topScore < 100))
            System.out.println("greater than second top score and less than 100");

        // || is eqaul to saying or
        if((topScore>90)||(secondTopScore<=90))
            System.out.println("at least one of these tests is true");

        // an error would occur if only one equals sign was used for the if statement
        // because that is assignment
        int newValue = 50;
        if(newValue==50)
            System.out.println("this is correct");

        boolean isCar=false;
        if(isCar==true)
            System.out.println("this is false");

        // if isCar=true return the output wasCar is true
        // if is Car=False do nothing
        isCar=true;
        boolean wasCar = isCar ? true : false;
        if(wasCar)
            System.out.println("wasCar is true");

        double myValue = 20d;
        double myValue2 =80d;
        double newresult = (myValue+myValue2) * 25;
        System.out.println("my total = "+ newresult);
        // newresult%=40 was also a valid option
        newresult= newresult % 40;
        System.out.println("my remainder is " + newresult);
        if (newresult <= 20)
            System.out.println("Total was over the limit");




    }
}
