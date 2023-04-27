package com.example.harjoitusty_arttu_korpela.lutemons.genThree;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Sportbike;

public class Superbike extends Sportbike {
    public Superbike(String nickname) {
        super(nickname);
        name = "Superbike";
        type = "KRK";
        level = "Epic";
        attack = new Attack("Chain whip",7);
        attack_rng = new Attack_rng("Highway havoc",6,8);
        defense = new Defense("Remove license plate", 8);
        experience = 0;
        health_buffer = 0;
        max_health = 14;
        health = 14;
        image = R.drawable.superbike;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
