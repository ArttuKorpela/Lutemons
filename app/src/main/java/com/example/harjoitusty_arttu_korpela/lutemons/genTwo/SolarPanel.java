package com.example.harjoitusty_arttu_korpela.lutemons.genTwo;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.BussCard;

public class SolarPanel extends BussCard {
    public SolarPanel(String nickname) {
        super(nickname);
        name = "Solar panel";
        this.nickname = nickname;
        type = "Pelletti";
        level = "Rare";
        attack = new Attack("Leaf blower",3);
        attack_rng = new Attack_rng("Falling branch",2,4);
        defense = new Defense("Block traffic", 10);
        experience = 0;
        health_buffer = 0;
        max_health = 16;
        health = 16;
        image = R.drawable.solar_panel_logo;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }
}
