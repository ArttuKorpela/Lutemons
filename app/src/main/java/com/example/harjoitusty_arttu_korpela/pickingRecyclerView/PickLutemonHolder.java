package com.example.harjoitusty_arttu_korpela.pickingRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.R;

public class PickLutemonHolder extends RecyclerView.ViewHolder {

    Button button;

    public PickLutemonHolder(@NonNull View itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.btnPick);
    }

}
