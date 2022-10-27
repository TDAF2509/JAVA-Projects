package com.TDAF;
//This class was created by Joe, used as a means of tracking the currently logged in user through the windows that they open.
//This means that if the user is a technician, or an office manager. the correct details can be pulled from the account to manipulate the page or
//the sql statement that they will be running.
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
