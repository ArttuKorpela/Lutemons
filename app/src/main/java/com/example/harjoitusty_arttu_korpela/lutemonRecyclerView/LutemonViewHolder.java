package com.example.harjoitusty_arttu_korpela.lutemonRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.R;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonImage;
    TextView names, level, health, exp, attack, attack_rng, defence;

    LinearLayoutCompat linearLayoutCompat;
    Button levelUp;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        linearLayoutCompat = itemView.findViewById(R.id.cardLutemon);
        lutemonImage = itemView.findViewById(R.id.imgLutemon);
        names = itemView.findViewById(R.id.txtLutemonNames);
        level = itemView.findViewById(R.id.txtLevel);
        health = itemView.findViewById(R.id.txtHealth);
        exp = itemView.findViewById(R.id.txtExp);
        attack = itemView.findViewById(R.id.txtAttack);
        attack_rng = itemView.findViewById(R.id.txtAttack_rng);
        defence = itemView.findViewById(R.id.txtDefence);
        levelUp = itemView.findViewById(R.id.btnLevelUp);
    }
}
