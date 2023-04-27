package com.example.harjoitusty_arttu_korpela.fallenRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.R;

public class FallenLutemonHolder extends RecyclerView.ViewHolder {

    ImageView lutemonImage;
    TextView names, level, health, exp, attack;

    Button revive;

    LinearLayoutCompat linearLayoutCompat;


    public FallenLutemonHolder(@NonNull View itemView) {
        super(itemView);
        linearLayoutCompat = itemView.findViewById(R.id.cardLutemon);
        lutemonImage = itemView.findViewById(R.id.imgLutemon);
        names = itemView.findViewById(R.id.txtLutemonNames);
        level = itemView.findViewById(R.id.txtLevel);
        health = itemView.findViewById(R.id.txtHealth);
        exp = itemView.findViewById(R.id.txtExp);
        revive = itemView.findViewById(R.id.btnRevive);
    }
}
