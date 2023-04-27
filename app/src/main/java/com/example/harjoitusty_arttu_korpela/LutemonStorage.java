package com.example.harjoitusty_arttu_korpela;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class LutemonStorage implements Serializable {

    private static LutemonStorage single_instance = null;
    ArrayList<Lutemon> currentLutemons = new ArrayList<>();


    private LutemonStorage(){}

    public static synchronized LutemonStorage getInstance() {
        if (single_instance == null){
            single_instance = new LutemonStorage();
        }

        return single_instance;
    }

    public void addLutemon(Lutemon newLutemon){

        currentLutemons.add(newLutemon);
    }

    public void winnerTreatment(Lutemon expLutemon){

        expLutemon.setExperience(expLutemon.getExperience() + 10);
        expLutemon.setHealth(expLutemon.max_health);
        expLutemon.addWin();
        currentLutemons.add(expLutemon);
        Home.getInstance().addKelaBucks(100);
    }

    public void loserTreatment(Lutemon expLutemon){
        expLutemon.setExperience(expLutemon.getExperience() + 5);
        expLutemon.setHealth(0);
        FallenLutemonStorage.getInstance().addLutemon(expLutemon);
        Home.getInstance().addKelaBucks(50);
    }

    public ArrayList<Lutemon> getCurrentLutemons() {
        return currentLutemons;
    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            userWriter.writeObject(currentLutemons);
            userWriter.close();

        } catch (IOException e) {
            System.out.println("Käyttäjien tallentaminen ei onnistunut");
            throw new RuntimeException(e);

        }

    }

    public void loadLutemon(Context context) {
        try {
            ObjectInputStream rocketReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            currentLutemons = (ArrayList<Lutemon>) rocketReader.readObject();
            rocketReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }

}
