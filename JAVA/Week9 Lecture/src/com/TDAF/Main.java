package com.TDAF;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> first = new ArrayList<String>();
        ArrayList<String> second = new ArrayList<String>();
        ArrayList<Integer> inttype = new ArrayList<Integer>();
        first.add("I");
        first.add("love");
        first.add("Java");
        second.add("but");
        second.add("not");
        second.add("today");
        first.addAll(second);
        first.set(3,"including");
        first.remove("not");
        System.out.println(first);

        Set<String> set1 = new HashSet<String>();
        set1.add("I");
        set1.add("Love");
        set1.add("Java");
        set1.add("I");
        System.out.println(set1);
        Set<String> set2 = new HashSet<String>();
        set2.add("I");
        set2.add("Love");
        set2.add("Python");
        System.out.println(set2);
        set1.removeAll(set2);
        System.out.println(set1);
        Set<String> set3 = new HashSet<String>(set1);





    }


}
