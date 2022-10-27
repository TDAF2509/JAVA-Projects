package com.TDAF;

public class Tree {
    private Tree left;
    private Tree right;

    public Tree(){
        left = null;
        right = null;
    }

    public Tree(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }
}
