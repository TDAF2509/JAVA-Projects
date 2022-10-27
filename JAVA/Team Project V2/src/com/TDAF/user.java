package com.TDAF;

public class user {
    private String name;
    private String password;
    private String role;

    public user(String nme,String pass,String rle ){
        this.name = nme;
        this.password = pass;
        this.role = rle;
    }
    public String getname(){return this.name;}
    public String getpassword(){return this.password;}
    public String getrole(){return this.role;}

}
