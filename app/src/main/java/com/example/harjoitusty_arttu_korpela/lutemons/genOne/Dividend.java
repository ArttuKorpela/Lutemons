package com.example.harjoitusty_arttu_korpela.lutemons.genOne;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.R;

public class Dividend extends Lutemon {

    public Dividend(String nickname) {
        name = "Dividend";
        this.nickname = nickname;
        type = "Enklaavi";
        level = "Common";
        attack = new Attack("Budget blast",1);
        attack_rng = new Attack_rng("Risky business",0,8);
        defense = new Defense("Pappa betalar", 2);
        experience = 0;
        health_buffer = 0;
        max_health = 6;
        health = 6;
        image = R.drawable.dividendwithlogo;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
