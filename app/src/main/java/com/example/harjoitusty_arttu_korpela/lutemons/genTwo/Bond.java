package com.example.harjoitusty_arttu_korpela.lutemons.genTwo;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Dividend;

public class Bond extends Dividend {
    public Bond(String nickname) {
        super(nickname);
        name = "Dividend";
        this.nickname = nickname;
        type = "Enklaavi";
        level = "Rare";
        attack = new Attack("Budget blast",3);
        attack_rng = new Attack_rng("Risky business",0,10);
        defense = new Defense("Pappa betalar", 3);
        experience = 0;
        health_buffer = 0;
        max_health = 12;
        health = 12;
        image = R.drawable.bond;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
