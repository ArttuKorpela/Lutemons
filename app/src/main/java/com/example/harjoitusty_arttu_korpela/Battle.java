package com.example.harjoitusty_arttu_korpela;

import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Ampere;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.BussCard;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Dividend;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Megabyte;
import com.example.harjoitusty_arttu_korpela.lutemons.genOne.Moped;
import com.example.harjoitusty_arttu_korpela.lutemons.genThree.MiniReactor;
import com.example.harjoitusty_arttu_korpela.lutemons.genThree.Option;
import com.example.harjoitusty_arttu_korpela.lutemons.genThree.Superbike;
import com.example.harjoitusty_arttu_korpela.lutemons.genThree.Terabyte;
import com.example.harjoitusty_arttu_korpela.lutemons.genThree.Tesla;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Bond;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Faraday;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Gigabyte;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.SolarPanel;
import com.example.harjoitusty_arttu_korpela.lutemons.genTwo.Sportbike;

import java.util.ArrayList;

public class Battle {

    public Battle(){};




    public Boolean confrontation(Lutemon lutemon1, Lutemon lutemon2, int ammount) {

        //get health to keep it so the corrected health doesn't increase health
        int health = lutemon2.getHealth();
        //Check if the lutemon has a buffer before doing damage
        int correctedDamageAmmount = 0;
        //Add the buffer and current health
        correctedDamageAmmount = (lutemon2.getHealth_buffer() + lutemon2.getHealth());
        //Take out the damage
        correctedDamageAmmount -= ammount;

        if (correctedDamageAmmount <= 0) {

            //If the correrted damage is over zero, the lutemon falls and it's abilities and health reset
            lutemon2.setHealth(0);
            lutemon2.setHealth_buffer(0);
            return false;//Lutemon2 has fallen
        } else {
            //Check that the lutemon doesn't gain health
            if (health < correctedDamageAmmount) {correctedDamageAmmount = health;};

            lutemon2.setHealth(correctedDamageAmmount);
            //Null the buffer
            lutemon2.setHealth_buffer(0);
            return true;//Notifies the activity that the lutemon2 has survived

        }
    }

    public void defendLutemon(Lutemon lutemon){
        //Lutemons health buffer is set to match it's defence stat
        lutemon.setHealth_buffer(lutemon.getDefense().getAmmmount());
    }

    public Lutemon getEnemy(String level){
        int max = 4;
        int min = 0;
        int randN;

        ArrayList<Lutemon> enemiesCommon = new ArrayList<>();
        enemiesCommon.add(new Megabyte("Juho"));
        enemiesCommon.add(new Ampere("Matti"));
        enemiesCommon.add(new Dividend("Eetu"));
        enemiesCommon.add(new BussCard("Jenna"));
        enemiesCommon.add(new Moped("Laura"));

        ArrayList<Lutemon> enemiesRare = new ArrayList<>();
        enemiesRare.add(new Gigabyte("Seppo"));
        enemiesRare.add(new Faraday("Jouni"));
        enemiesRare.add(new Bond("Nina"));
        enemiesRare.add(new SolarPanel("Ukko"));
        enemiesRare.add(new Sportbike("Ada"));

        ArrayList<Lutemon> enemiesEpic = new ArrayList<>();
        enemiesRare.add(new Terabyte("Vihtori"));
        enemiesRare.add(new Tesla("Iisakki"));
        enemiesRare.add(new Option("Taavetti"));
        enemiesRare.add(new MiniReactor("Ilmari"));
        enemiesRare.add(new Superbike("Eero"));



        randN = (int) (Math.random() * (max - min + 1) + min);

        switch (level) {
            case "Common":
                return enemiesCommon.get(randN);
            case "Rare":
                return enemiesRare.get(randN);
            case "Epic":
                return enemiesEpic.get(randN);
            default:
                return enemiesCommon.get(randN);
        }
    }
}
