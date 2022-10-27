package com.TDAF;

public class Buyer {
    private Shop shopToGo;
    private int[] articlesToBuy;

    public Buyer(Shop shopToGo, int[] articlesToBuy) {
        this.shopToGo = shopToGo;
        this.articlesToBuy = articlesToBuy;
    }

    public Shop getShopToGo() {
        return shopToGo;
    }

    public void setShopToGo(Shop shopToGo) {
        this.shopToGo = shopToGo;
    }

    public int[] getArticlesToBuy() {
        return articlesToBuy;
    }

    public void setArticlesToBuy(int[] articlesToBuy) {
        this.articlesToBuy = articlesToBuy;
    }
}
