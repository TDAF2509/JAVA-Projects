package com.TDAF;

public class Shop {
    private String name;
    private int numberOfArticles;
    private int[] articles = new int[numberOfArticles];

    public Shop(String name, int numberOfArticles, int[] articles) {
        this.name = name;

        this.numberOfArticles = numberOfArticles;

        this.articles = articles;

    }

    {
        System.out.println("Welcome to the new shop: "+name);
    }

    public Shop() {
        this.name = "Shop open soon";
        this.numberOfArticles = 0;
        this.articles = new int[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    public void setNumberOfArticles(int numberOfArticles) {
        if (numberOfArticles<0){
            System.out.println("Only positive numbers allowed");
        }else {
            this.numberOfArticles = numberOfArticles;
        }
    }

    public int[] getArticles() {
        return articles;
    }

    public void setArticles(int[] articles) {
        for (int i=0 ; i<articles.length;i++){
            if(articles[i]<0){
                System.out.println("only positive numbers allowed");
            }else{
                this.articles=articles;
            }
        }
    }

    public void reduce(int i) {
        if (articles[i]>0){
            articles[i]=articles[i]-i;
        }

    }
}
