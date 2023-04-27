package com.example.harjoitusty_arttu_korpela.lutemons.genOne;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.R;

public class Ampere extends Lutemon {

    public Ampere(String nickname) {
        name = "Ampere";
        this.nickname = nickname;
        type = "Satky";
        level = "Common";
        attack = new Attack("Spark",4);
        attack_rng = new Attack_rng("Short circuit",2,6);
        defense = new Defense("Fuse", 2);
        experience = 0;
        health_buffer = 0;
        max_health = 5;
        health = 5;
        image = R.drawable.amperewithlogo;
        id = idCounter++; //Every generated Ampere gets a unique id using the Lutemon classes id counter.
    }
}
