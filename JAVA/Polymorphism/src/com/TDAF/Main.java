package com.TDAF;

class Character {
    private String name;

    public Character(String name) {
        this.name = name;
    }

    public String Alias(){
        return "No Alias here";
    }

    public String getName() {
        return name;
    }
}

class SpiderMan extends Character {
    public SpiderMan(){
        super("Spider-Man");
    }

    @Override
    public String Alias() {
        return "Web head";
    }
}

class BatMan extends Character {
    public BatMan(){
        super("Batman");
    }

    @Override
    public String Alias() {
        return "The dark knight";
    }
}

class Thor extends Character {
    public Thor(){
        super("Thor");
    }

    @Override
    public String Alias() {
        return "God of thunder";
    }
}

class Flash extends Character {
    public Flash(){
        super("Flash");
    }

    @Override
    public String Alias() {
        return "The fastest man alive";
    }
}

class GhostRider extends Character {
    public GhostRider(){
        super("GhostRider");
    }

    @Override
    public String Alias() {
        return "The Spirit of Vengance";
    }
}

class SuperMan extends Character {
    public SuperMan(){
        super("SuperMan");
    }

    @Override
    public String Alias() {
        return "The Man of steel";
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i =1; i<11 ; i++){
            Character character = randomCharacter();
            System.out.println("Character "+i+" : "+character.getName()+"\n"+"Alias: "+character.Alias()+"\n");
        }
    }

    public static Character randomCharacter(){
        // Math.random selects a random number between 0 and 1
        // Therefore the range needed to be increased hence why
        // it has been multiplied. However by multiplying by 6
        // it still has a range between 0 and 5, this is why 1
        // is added so a range of 1 to 6 is created.
        int randomNumber = (int) (Math.random()*6)+1;
        System.out.println("Random number generated was : "+randomNumber);
        switch (randomNumber){
            case 1:
                return new SpiderMan();
            case 2:
                return new BatMan();
            case 3:
                return new Thor();
            case 4:
                return new Flash();
            case 5:
                return new GhostRider();
            case 6:
                return new SuperMan();
        }

        return null;
    }
}


