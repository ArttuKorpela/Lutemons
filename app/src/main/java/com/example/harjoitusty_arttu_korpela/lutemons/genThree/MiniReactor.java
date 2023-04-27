package com.example.harjoitusty_arttu_korpela.lutemons.genThree;

import com.example.harjoitusty_arttu_korpela.Attack;
import com.example.harjoitusty_arttu_korpela.Attack_rng;
import com.example.harjoitusty_arttu_korpela.Defense;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.SolarPanel;

public class MiniReactor extends SolarPanel {
    public MiniReactor(String nickname) {
        super(nickname);
        name = "MiniReactor";
        this.nickname = nickname;
        type = "Pelletti";
        level = "Epic";
        attack = new Attack("Leaf blower",5);
        attack_rng = new Attack_rng("Falling branch",4,6);
        defense = new Defense("Block traffic", 14);
        experience = 0;
        health_buffer = 0;
        max_health = 32;
        health = 32;
        image = R.drawable.reaktori_logo;
        id = idCounter++; //Every generated Megabyte gets a unique id using the Lutemon classes id counter.
    }

}
