package com.example.harjoitusty_arttu_korpela.lutemons.genOne;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.R;

public class BussCard extends Lutemon {

    public BussCard(String nickname) {
        name = "Buss card";
        this.nickname = nickname;
        type = "Pelletti";
        level = "Common";
        attack = new Attack("Leaf blower",2);
        attack_rng = new Attack_rng("Falling branch",1,3);
        defense = new Defense("Block traffic", 6);
        experience = 0;
        health_buffer = 0;
        max_health = 8;
        health = 8;
        image = R.drawable.buss_card_2_0;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
