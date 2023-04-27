package com.example.harjoitusty_arttu_korpela;

import java.io.Serializable;

public class Defense implements Serializable {

    private String name;

    public Defense(String name, int ammmount) {
        this.name = name;
        this.ammmount = ammmount;
    }

    private int ammmount;

    public String getName() {
        return name;
    }

    public int getAmmmount() {
        return ammmount;
    }
}
