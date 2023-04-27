/*
----------------------------------------------------------------------------------------------------
This class gives the lutemons their first attack ability. It outputs
always outputs a set value
----------------------------------------------------------------------------------------------------
*/package com.example.harjoitusty_arttu_korpela;

import java.io.Serializable;

public class Attack implements Serializable {
    private String name;

    private int ammmount;

    public Attack(String name, int ammmount) {
        this.name = name;
        this.ammmount = ammmount;
    }

    public String getName() {
        return name;
    }

    public int getAmmmount() {
        return ammmount;
    }
}
