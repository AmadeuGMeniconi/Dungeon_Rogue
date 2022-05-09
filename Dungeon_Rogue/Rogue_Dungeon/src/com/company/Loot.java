package com.company;

public enum Loot {
    GOLD("Gold", 100, 40),
    SILVER("Silver", 50, 50),
    BRONZE("Bronze", 10, 60);

    private String _type;
    private int _value;
    private int _chance;

    Loot(String type, int value, int chance) {
        this._type = type;
        this._value = value;
        this._chance = chance;
    }

    public String get_type() {
        return _type;
    }
    public int get_value() {
        return _value;
    }
    public int get_chance() {
        return _chance;
    }
}
