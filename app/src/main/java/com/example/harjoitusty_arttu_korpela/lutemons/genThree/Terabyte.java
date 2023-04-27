package com.example.harjoitusty_arttu_korpela.lutemons.genThree;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Gigabyte;

public class Terabyte extends Gigabyte {
    public Terabyte(String nickname) {
        super(nickname);
        name = "Terabyte";
        level = "Epic";
        attack = new Attack("Memory leak",6);
        attack_rng = new Attack_rng("Garbage collector",4,8);
        defense = new Defense("Hide in moms basement", 10);
        experience = 0;
        health_buffer = 0;
        max_health = 18;
        health = 18;
        image = R.drawable.terabyte;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
