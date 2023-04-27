package com.example.harjoitusty_arttu_korpela;

public class Counter {

    public Counter() {}

    private static int wins = 0, losses = 0;




    public void addLoss() {losses++;}

    public void addWin() {wins++;}


    public static int getWins() {
        return wins;
    }

    public static int getLosses() {
        return losses;
    }
}
