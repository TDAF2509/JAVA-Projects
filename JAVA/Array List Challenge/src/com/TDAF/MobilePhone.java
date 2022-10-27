package com.TDAF;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> contactList;

    public MobilePhone(String myNumber){
        this.myNumber= myNumber;
        this.contactList= new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact){
        if (findContact(contact.getName())>=0){
            System.out.println("Contact is already on file");
            return false;
        }

        contactList.add(contact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPos= findContact(oldContact);
        if (foundPos<0){
            System.out.println(oldContact.getName()+" , was not found");
            return false;
        }else if (findContact(newContact.getName()) !=-1){
            System.out.println("Contact with name "+ newContact.getName()+
            " already exists. Update was not successful.");
            return false;
        }

        this.contactList.set(foundPos,newContact);
        System.out.println(oldContact.getName()+" was replaced with "+newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contacts){
        int foundpos=findContact(contacts);
        if (foundpos<0){
            System.out.println(contacts.getName()+" , was not found");
            return false;
        }
        this.contactList.remove(foundpos);
        System.out.println(contacts.getName()+" , was deleted");
        return true;
    }

    public void printContacts(){
        System.out.println("Contact List");
        for (int i=0;i<this.contactList.size();i++){
            System.out.println((i+1)+"."+
                    this.contactList.get(i).getName()+"-->"+
                    this.contactList.get(i).getNumber());
        }
    }

    private int findContact(Contacts contacts){
        return this.contactList.indexOf(contacts);
    }

    private int findContact(String contactName){
        for (int i=0; i<this.contactList.size();i++){
            Contacts contacts =this.contactList.get(i);
            if (contacts.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contacts) {
        if (findContact(contacts)>=0){
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if (position>=0){
            return this.contactList.get(position);
        }
        return null;
    }

    public void printContact(){
        System.out.println("Contact List");
        for (int i=0; i<this.contactList.size(); i++){
            System.out.println((i+1) + "."+
            this.contactList.get(i).getName()+"->"+
            this.contactList.get(i).getNumber());
        }
    }


}
