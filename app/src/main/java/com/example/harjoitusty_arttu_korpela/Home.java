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

public class Home {

    //The currency always at the beginning starts at 300
    private static int kela_bucks = 300;
    private static Home single_instance = null;

    public Home() {
    }

    public static synchronized Home getInstance() {
        if (single_instance == null){
            single_instance = new Home();
        }
        return single_instance;
    }

    //If enough funds, a new lutemon is created
    public Boolean createLutemon(String nickname, String Type){

        if (kela_bucks < 100) {
            return false;
        }else {
            Lutemon lutemonToBeAdded;
            switch (Type) {
                case "Cluster":
                    lutemonToBeAdded = new Megabyte(nickname);
                    break;
                case "Enklaavi":
                    lutemonToBeAdded = new Dividend(nickname);
                    break;
                case "Pelletti":
                    lutemonToBeAdded = new BussCard(nickname);
                    break;
                case "KRK":
                    lutemonToBeAdded = new Moped(nickname);
                    break;
                case "Satky":
                    lutemonToBeAdded = new Ampere(nickname);
                    break;
                default:
                    System.out.println("Virhe home:n createLutemonissa");
                    return false;

            }

            LutemonStorage.getInstance().addLutemon(lutemonToBeAdded);
            setKela_bucks(kela_bucks-100);
            return true;
        }

    }
    //Level up takes your lutemon and makes rarer lutemon with the same type
    public Lutemon levelUp(Lutemon lutemon){

        String lutemonLevel = lutemon.getLevel();

        switch (lutemon.getType()) {
            case "Cluster":
                if (lutemonLevel.equals("Common")) {lutemon = new Gigabyte(lutemon.getNickname());
                } else {lutemon = new Terabyte(lutemon.getNickname());}
                break;
            case "Enklaavi":
                if (lutemonLevel.equals("Common")) {lutemon = new Bond(lutemon.getNickname());
                } else {lutemon = new Option(lutemon.getNickname());}
                break;
            case "Pelletti":
                if (lutemonLevel.equals("Common")) {lutemon = new SolarPanel(lutemon.getNickname());
                } else {lutemon = new MiniReactor(lutemon.getNickname());}
                break;
            case "KRK":
                if (lutemonLevel.equals("Common")) {lutemon = new Sportbike(lutemon.getNickname());
                } else {lutemon = new Superbike(lutemon.getNickname());}
                break;
            case "Satky":
                if (lutemonLevel.equals("Common")) {lutemon = new Faraday(lutemon.getNickname());
                } else {lutemon = new Tesla(lutemon.getNickname());}
                break;
            default:
                System.out.println("Virhe home:n uprgradeLutemonissa");

        }
        return lutemon;
    };

    public int getKela_bucks() {
        return kela_bucks;
    }

    public void setKela_bucks(int kela_bucks) {
        Home.kela_bucks = kela_bucks;
    }

    public void addKelaBucks(int ammount) {
        setKela_bucks(getKela_bucks() + ammount);}
    }
