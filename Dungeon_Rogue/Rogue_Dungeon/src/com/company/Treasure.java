package com.company;

public class Treasure extends Dungeon {

    public Treasure() {

        if (r.nextInt(0,100) <= Loot.GOLD.get_chance()) {
            this.set_Type(Loot.GOLD.get_type());
            this.set_Value(Loot.GOLD.get_value());
            set_initLocation(this.get_Type());
        }
        if (r.nextInt(0, 100) <= Loot.SILVER.get_chance()) {
            this.set_Type(Loot.SILVER.get_type());
            this.set_Value(Loot.SILVER.get_value());
            set_initLocation(this.get_Type());
        }
        if (r.nextInt(0, 100) <= Loot.BRONZE.get_chance()) {
            this.set_Type(Loot.BRONZE.get_type());
            this.set_Value(Loot.BRONZE.get_value());
            set_initLocation(this.get_Type());
        }

    }

}
