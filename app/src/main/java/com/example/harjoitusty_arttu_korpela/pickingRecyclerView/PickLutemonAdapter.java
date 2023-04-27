package com.example.harjoitusty_arttu_korpela.pickingRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.Activitys.BattleActivity;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.R;

import java.util.ArrayList;

public class PickLutemonAdapter extends RecyclerView.Adapter<PickLutemonHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();


    public PickLutemonAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public PickLutemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PickLutemonHolder(LayoutInflater.from(context).inflate(R.layout.pick_lutemon_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PickLutemonHolder holder, int position) {
        //Set the lutemon name and nickname to the button
        holder.button.setText(lutemons.get(position).getName() + " " + lutemons.get(position).getNickname());

        //Set an on click listenere that gets the correct lutemon when it's button is pressed.
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                Intent intentBattle = new Intent(context, BattleActivity.class);
                intentBattle.putExtra("lutemonKey", lutemons.get(adapterPosition));
                lutemons.remove(adapterPosition);
                context.startActivity(intentBattle);
            }
        });
    }


    @Override
    public int getItemCount() {
        return LutemonStorage.getInstance().getCurrentLutemons().size();
    }


}
