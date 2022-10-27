package com.TDAF;

public class Windows {
    private String type;
    private int panels;
    private boolean tinted;

    public Windows(String type, int panels, boolean tinted) {
        this.type = type;
        this.panels = panels;
        this.tinted = tinted;
    }

    public String getType() {
        return type;
    }

    public int getPanels() {
        System.out.println("The window has "+getPanels()+" glass panels");
        return panels;
    }

    public boolean isTinted() {
        if (tinted==true){
            System.out.println("The window is tinted");
        }
        return tinted;
    }
}
