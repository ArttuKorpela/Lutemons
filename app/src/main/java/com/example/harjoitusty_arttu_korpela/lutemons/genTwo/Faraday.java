package com.example.harjoitusty_arttu_korpela.lutemons.genTwo;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Ampere;

public class Faraday extends Ampere {

    public Faraday(String nickname) {
        super(nickname);
        name = "Faraday";
        type = "Satky";
        level = "Rare";
        attack = new Attack("Spark",6);
        attack_rng = new Attack_rng("Short circuit",4,8);
        defense = new Defense("Fuse", 4);
        experience = 0;
        health_buffer = 0;
        max_health = 10;
        health = 10;
        image = R.drawable.faraday;
        id = idCounter++; //Every generated Ampere gets a unique id using the Lutemon classes id counter.
    }
}
