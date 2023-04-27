package com.example.harjoitusty_arttu_korpela.lutemons.genTwo;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Moped;

public class Sportbike extends Moped {
    public Sportbike(String nickname) {
        super(nickname);
        name = "Sportbike";
        this.nickname = nickname;
        type = "KRK";
        level = "Rare";
        attack = new Attack("Chain whip",5);
        attack_rng = new Attack_rng("Highway havoc",4,6);
        defense = new Defense("Remove license plate", 6);
        experience = 0;
        health_buffer = 0;
        max_health = 10;
        health = 10;
        image = R.drawable.sportbike;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
