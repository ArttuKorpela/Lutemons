package com.example.harjoitusty_arttu_korpela.lutemons.genOne;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.R;

public class Moped extends Lutemon {
    public Moped(String nickname) {
        name = "Moped";
        this.nickname = nickname;
        type = "KRK";
        level = "Common";
        attack = new Attack("Chain whip",3);
        attack_rng = new Attack_rng("Highway havoc",2,4);
        defense = new Defense("Remove license plate", 4);
        experience = 0;
        health_buffer = 0;
        max_health = 6;
        health = 6;
        image = R.drawable.mopedwithlogo;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
