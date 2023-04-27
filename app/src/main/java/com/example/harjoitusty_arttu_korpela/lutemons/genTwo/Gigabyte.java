package com.example.harjoitusty_arttu_korpela.lutemons.genTwo;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Megabyte;

public class Gigabyte extends Megabyte {


    public Gigabyte(String nickname) {
        super(nickname);
        name = "Gigabyte";
        level = "Rare";
        attack = new Attack("Memory leak",4);
        attack_rng = new Attack_rng("Garbage collector",2,6);
        defense = new Defense("Hide in moms basement", 8);
        experience = 0;
        health_buffer = 0;
        max_health = 12;
        health = 12;
        image = R.drawable.gigabyte;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
