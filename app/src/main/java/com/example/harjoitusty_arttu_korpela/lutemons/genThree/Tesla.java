package com.example.harjoitusty_arttu_korpela.lutemons.genThree;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Faraday;

public class Tesla extends Faraday {

    public Tesla(String nickname) {
        super(nickname);
        name = "Faraday";
        type = "Satky";
        level = "Epic";
        attack = new Attack("Spark",8);
        attack_rng = new Attack_rng("Short circuit",6,10);
        defense = new Defense("Fuse", 6);
        experience = 0;
        health_buffer = 0;
        max_health = 14;
        health = 14;
        image = R.drawable.tesla;
        id = idCounter++; //Every generated Ampere gets a unique id using the Lutemon classes id counter.
    }

}
