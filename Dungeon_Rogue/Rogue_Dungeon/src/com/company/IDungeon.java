package com.company;

public interface IDungeon {

    void set_initLocation(String type);

    void set_currentLocation(String type, String direction);

    int[] get_Location();

    int get_LocationX();

    int get_LocationY();



}
