package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //Display Title
        System.out.println("================ DWARF DUNGEON =================");

        //Set game difficulty
        final int LEVEL = Dungeon.chooseDifficulty();

        //Set dungeon size based on game difficulty
        Dungeon.set_DUNGEONSIZE(LEVEL);

        //Create player object
        Player hero = new Player("Hero");

        //Create exit object
        Exit exit = new Exit("Exit");

        //Relay dungeon size to user
        System.out.println("\nDungeon Size: " + Dungeon.DUNGEONSIZE + " x " + Dungeon.DUNGEONSIZE + " rooms");

        //Quick Tutorial guide
        System.out.println("\nTUTORIAL:\nYou are a valiant spelunker with a MAP! You've delve into the DUNGEONS in search of riches! But beware! " + "There be MONSTERS!\n" + "The way you move through the DUNGEON is based on a system of COORDINATES [X,Y]. You move from ROOM to ROOM and each\n" +
                "room has a unique COORDINATE [X,Y]. Use \"W\", \"A\", \"S\" or \"D\" to change you own COORDINATES [X,Y] position to match that of the ROOMS of the DUNGEON. Then \"Enter\" to confirm!\n" +
                "The OBJECTIVE is to gather as much TREASURE in you POCKET as you can and EXIT the DUNGEON alive. Good luck!\n");

        //Create treasure objects in treasure array
        Treasure[] treasures = new Treasure[10*LEVEL];
        for(int i = 0; i < treasures.length; i++) {
            treasures[i] = new Treasure();
        }

        //Create monster objects in monster array
        String[] monster_types = {"Chimera", "Ghoul", "Skeleton", "Ghost", "Imp", "Giant Spider", "Giant Snake"};
        Random random = new Random();
        Monster[] monsters = new Monster[5*LEVEL];
        for(int i = 0; i < monsters.length; i++) {
            int choose = random.nextInt(monster_types.length);
            monsters[i] = new Monster(monster_types[choose]);
            //Show monster locations (Debugging):
            //System.out.println(monsters[i].get_Type()+ " at room " + Arrays.toString(monsters[i].get_Location()) + " !!!");
        }

        //Game "start screen"
        System.out.println("\n================= GATHER THE RICHES AND EXIT THE DUNGEON =================\n");
        System.out.println("You've entered the Dungeon! You're currently in room " + Arrays.toString(hero.get_Location()));

        //The Game (loop frames update):
        boolean GameOver;
        int round = 1;
        while(true){

            //Check for encounter with treasures from treasure array
            for (Treasure treasure : treasures) {
                hero.encounter(treasure);
            }

            //Check for encounter with the Exit
            GameOver = hero.encounter(exit);
            if (GameOver) System.exit(0);

            //Check for encounter with monsters from monster array
            for (Monster monster : monsters) {
                GameOver = hero.encounter(monster);
                if (GameOver) System.exit(0);
            }

            System.out.println("\n=============================== INVENTORY =====================================");

            System.out.println("\nPOCKET: " + hero.get_Pocket());

            System.out.println("\nDUNGEON TREASURE MAP: ");
            for(int i = 0; i < treasures.length; i++) {
                if (treasures[i].get_Type() != null)
                    System.out.println("- " + treasures[i].get_Type() + " in room " + Arrays.toString(treasures[i].get_Location()));
            }

            System.out.println("\n=================================== ROUND " + round + " ===================================");

            System.out.println("\nDUNGEON EXIT IN ROOM " + Arrays.toString(exit.get_Location()));

            System.out.println("\nCURRENT ROOM " + Arrays.toString(hero.get_Location()));

            System.out.println("\nUSE \"W\", \"A\", \"S\" or \"D\" TO MOVE THROUGH THE DUNGEON. THEN PRESS \"ENTER\" TO CONFIRM: ");

            round += 1;

            //User's Command input
            hero.walk();

            System.out.println("\n===============================================================================");
        }

    }

}
