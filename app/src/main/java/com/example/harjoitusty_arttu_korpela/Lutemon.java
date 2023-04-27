package com.example.harjoitusty_arttu_korpela;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name, nickname, type, level;
    protected Attack attack;
    protected Attack_rng attack_rng;
    protected Defense defense;
    protected int experience, health_buffer, max_health, health,id, image, wins = 0;

    protected static int idCounter = 0;

    public void addWin() {wins++;}


    public Boolean heal(){
        if (health >= max_health) {
            health = max_health;
            return false;
        }
        else {health++;
        return true;
        }
    }


    public void defend() {
        health_buffer = defense.getAmmmount();
    }

    public int getWins() {return wins;}

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public Attack getAttack() {
        return attack;
    }

    public Attack_rng getAttack_rng() {
        return attack_rng;
    }

    public void setHealth_buffer(int health_buffer) {
        this.health_buffer = health_buffer;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Defense getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth_buffer() {
        return health_buffer;
    }

    public int getMax_health() {
        return max_health;
    }

    public int getHealth() {
        return health;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public static int getIdCounter() {
        return idCounter;
    }
}
