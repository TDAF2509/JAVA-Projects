package com.TDAF;

public class Main {

    public static void main(String[] args) {
//	Player player = new Player();
//	player.name = "Tim";
//	player.health = 20;
//	player.weapon = "Sword";
//
//	int damage = 10;
//	player.loseHealth(damage);
//        System.out.println("Remaining health = "+player.healthREmaining());
//
//        damage = 11;
//        player.health = 100;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = "+player.healthREmaining());

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Tayo",100,"Sword");
        System.out.println("Initial health is "+enhancedPlayer.health);
    }
}
