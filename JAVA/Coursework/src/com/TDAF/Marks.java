package com.TDAF;

import java.util.HashMap;
import java.util.Map;

public class Marks {
    private HashMap<Team,Integer> mark;

    public Marks() {
        mark=new HashMap<Team,Integer>();
    }

    public Map<Team, Integer> getMark() {
        return mark;
    }

    public void setMark(HashMap<Team, Integer> mark) {
        this.mark = mark;
    }
}
