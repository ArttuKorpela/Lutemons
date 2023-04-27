package com.example.harjoitusty_arttu_korpela;

import java.io.Serializable;
import java.util.TimerTask;

public class HealingTimer extends TimerTask implements Serializable {

    public void run() {
        //The timer goes through the storages list and heals the lutemon
        for (Lutemon obj : FallenLutemonStorage.getInstance().getCurrentLutemons()) {
            obj.heal();
        }
    }

}
