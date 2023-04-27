package com.example.harjoitusty_arttu_korpela.lutemons.genOne;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.R;

import java.io.Serializable;

public class Megabyte extends Lutemon implements Serializable {

    public Megabyte(String nickname) {
        name = "Megabyte";
        this.nickname = nickname;
        type = "Cluster";
        level = "Common";
        attack = new Attack("Memory leak",2);
        attack_rng = new Attack_rng("Garbage collector",1,3);
        defense = new Defense("Hide in moms basement", 5);
        experience = 0;
        health_buffer = 0;
        max_health = 7;
        health = 7;
        image = R.drawable.megabyte_2_0;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
