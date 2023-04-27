package com.example.harjoitusty_arttu_korpela.lutemons.genThree;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Bond;

public class Option extends Bond {
    public Option(String nickname) {
        super(nickname);
        name = "Bond";
        type = "Enklaavi";
        level = "Epic";
        attack = new Attack("Budget blast",5);
        attack_rng = new Attack_rng("Risky business",0,12);
        defense = new Defense("Pappa betalar", 5);
        experience = 0;
        health_buffer = 0;
        max_health = 18;
        health = 18;
        image = R.drawable.optionlogo;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
