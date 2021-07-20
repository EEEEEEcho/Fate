package com.thinkInJava.chapter19;

import java.util.Locale;

public enum SpaceShip {
    SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase(Locale.ROOT);
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : SpaceShip.values()){
            System.out.println(s);
        }
    }
}
