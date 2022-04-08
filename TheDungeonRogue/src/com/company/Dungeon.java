package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dungeon implements IDungeon {

    public Dungeon(){
    }



    Random r = new Random();


    private int _pocket;

    public int get_Pocket(){
        return this._pocket;
    }

    public void set_Pocket(int value) {
        this._pocket += value;
    }


    private int _value;

    public int get_Value() {
        return this._value;
    }

    public void set_Value(int value){
        this._value = value;
    }


    private String _type;

    public String get_Type(){
        return this._type;
    }

    public void set_Type(String tipo){
        this._type = tipo;
    }


    static int DUNGEONSIZE;

    public static void set_DUNGEONSIZE(int level){
        DUNGEONSIZE = 10 * level;
    }


    private int[] _DungeonLocation = new int[] {0,0};

    public int[] get_Location() {
        return this._DungeonLocation;
    }

    public int get_LocationX() {
        return this._DungeonLocation[0];
    }

    public int get_LocationY() {
        return this._DungeonLocation[1];
    }

    public void set_initLocation(String type) {
        switch (type) {
            case "Hero":
                this._type = type;
                this._DungeonLocation[0] = 0;
                this._DungeonLocation[1] = 0;
                break;

            case "Ghoul":
            case "Chimera":
            case "Skeleton":
            case "Ghost":
            case "Imp":
            case "Giant Spider":
            case "Giant Snake":
            case "Exit":
            case "Gold":
            case "Silver":
            case "Bronze":
                this._type = type;
                this._DungeonLocation[0] = r.nextInt(DUNGEONSIZE+1);
                this._DungeonLocation[1] = r.nextInt(DUNGEONSIZE+1);
                break;

            default: throw new IllegalStateException("Unexpected value: " + type + ". Expected: \"Skeleton\", \"Ghost\" or \"Exit\"");
        }
    }

    public void set_currentLocation(String type, String direction) {
        switch (type) {
            case "Hero":
                switch (direction) {
                    case "W":
                        if (this.get_LocationY() >= DUNGEONSIZE) {
                            System.out.println("\nCan't move UP. You remain at room " + Arrays.toString(this.get_Location()));
                            break;
                        }
                        this._DungeonLocation[1] += 1;
                        System.out.println("\nYou moved UP to room " + Arrays.toString(this.get_Location()));
                        break;

                    case "S":
                        if (this.get_LocationY() <= 0) {
                            System.out.println("\nCan't move DOWN. You remain at room " + Arrays.toString(this.get_Location()));
                            break;
                        }
                        this._DungeonLocation[1] -= 1;
                        System.out.println("\nYou moved DOWN to room " + Arrays.toString(this.get_Location()));
                        break;

                    case "D":
                       if (this.get_LocationX() >= DUNGEONSIZE) {
                           System.out.println("\nCan't move RIGHT. You remain at room " + Arrays.toString(this.get_Location()));
                           break;
                       }
                        this._DungeonLocation[0] += 1;
                        System.out.println("\nYou moved RIGHT to room " + Arrays.toString(this.get_Location()));
                        break;

                    case "A":
                        if (this.get_LocationX() <= 0) {
                            System.out.println("\nCan't move LEFT. You remain at room " + Arrays.toString(this.get_Location()));
                            break;
                        }
                        this._DungeonLocation[0] -= 1;
                        System.out.println("\nYou moved LEFT to room " + Arrays.toString(this.get_Location()));
                        break;
                } break;
        }
    }


    static int chooseDifficulty() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Difficuty Level [1 = Easy, 2 = Medium, 3 = Hard]: ");
            String choice = scan.next();
            int level;
            if (choice.equals("3") || choice.equals("2") || choice.equals("1")) {
                level = Integer.parseInt(choice);
                return level;
            } else {
                System.out.println("Expected values: \"1\", \"2\" or \"3\". Try Again.");
            }
        }
    }
}

