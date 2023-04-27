package com.example.harjoitusty_arttu_korpela;

import java.util.ArrayList;

public class FallenLutemonStorage {

    private static FallenLutemonStorage single_instance = null;
    ArrayList<Lutemon> currentLutemons = new ArrayList<>();



    private FallenLutemonStorage(){}

    public static synchronized FallenLutemonStorage getInstance() {
        if (single_instance == null){
            single_instance = new FallenLutemonStorage();
        }


        return single_instance;
    }

    public void addLutemon(Lutemon newLutemon){

        currentLutemons.add(newLutemon);
    }


    public ArrayList<Lutemon> getCurrentLutemons() {
        return currentLutemons;
    }

}

