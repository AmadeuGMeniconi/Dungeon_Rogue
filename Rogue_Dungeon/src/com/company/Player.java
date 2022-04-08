package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Player extends Dungeon {

    public Player(String type) {
        set_initLocation(type);
    }

    public boolean encounter(Monster m) {
        if (Arrays.equals(this.get_Location(), m.get_Location())) {
            this.set_Pocket(0);
            m.description(m.get_Type());
            return true;
        }
        return false;
    }

    public boolean encounter(Exit e) {
        if (Arrays.equals(this.get_Location(), e.get_Location())) {
            System.out.println("\n====================================================================================");
            System.out.println("\nYou've encountered the " + e.get_Type() + ". You survived the Dungeon! And brought home: " + this.get_Pocket() + " Points!");
            System.out.println("\nYOU WIN");
            System.out.println("\n====================================================================================");
            return true;
        }
        return false;
    }

    public void encounter(Treasure t) {
        if (Arrays.equals(this.get_Location(), t.get_Location()) && t.get_Type() != null) {
            set_Pocket(t.get_Value());
            System.out.println("\n############## You've encountered " + t.get_Type() + "! Its worth: " + t.get_Value() + " Points ###############");
            t.set_Type(null);
        }
    }

    public void walk() {

        Scanner scan = new Scanner(System.in);
        String direction;
        boolean repeat = true;
        while (repeat) {
            direction = scan.next().toUpperCase();

            if (direction.equals("W") || direction.equals("A") || direction.equals("S") || direction.equals("D")) {
                set_currentLocation("Hero", direction);
                repeat = false;
            } else {
                System.out.println("Expected values: \"W\", \"A\", \"S\" or \"D\". Try Again.");
            }
        }

    }
}
