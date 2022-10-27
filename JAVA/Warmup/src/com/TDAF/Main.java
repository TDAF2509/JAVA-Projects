package com.TDAF;

public class Main {

    public float computeAverage(float [] data) {
        float sum = 0.0f;
        for (int i = 1; i < data.length; i++)
            sum += data[i];
        return (sum / data.length);
    }

    public static void main(String[] args) {
        float data[] = new float[] {6.0f, 5.0f, 1.0f};
        Main avg = new Main();
        float average = avg.computeAverage(data);
        System.out.println("Average = " + average);

    }
}
