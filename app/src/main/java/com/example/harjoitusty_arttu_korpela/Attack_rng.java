/*
----------------------------------------------------------------------------------------------------
This class gives the lutemons their second attack ability. It outputs
either the max or min value when .getAmmountRng is called. This is implemented with
the "next" -methdod where it return either 1 or 2 on a 50/50 chance.
----------------------------------------------------------------------------------------------------
*/

package com.example.harjoitusty_arttu_korpela;

import java.io.Serializable;
import java.util.Random;

public class Attack_rng implements Serializable {
    private String name;

    private int ammmount_min, ammmount_max;

    private final Random random = new Random();

    private int next() {
        if (random.nextBoolean()) {
            return 1;
        } else {
            return 2;
        }
    }

    public String getName() {
        return name;
    }

    public Attack_rng(String name, int ammmount_min, int ammmount_max) {
        this.name = name;
        this.ammmount_min = ammmount_min;
        this.ammmount_max = ammmount_max;
    }

    public int getAmmmountRng() {
        int n = next();
        if (n == 1) {
            return ammmount_min;
        } else {
            return ammmount_max;
        }
    }

    public int getAmmmount_min() {
        return ammmount_min;
    }

    public int getAmmmount_max() {
        return ammmount_max;
    }
}
