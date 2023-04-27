package com.example.harjoitusty_arttu_korpela.lutemonRecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.Home;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.R;

import java.util.ArrayList;

public class lutemonViewAdapter extends RecyclerView.Adapter<LutemonViewHolder>  {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();


    public lutemonViewAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view,parent,false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {

        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());
        holder.names.setText(lutemons.get(position).getName()+"  ''"+ lutemons.get(position).getNickname()+ "''");
        holder.level.setText(lutemons.get(position).getLevel());

        //Changes the color of the level textView based on what type the level is.
        if (lutemons.get(position).getLevel().equals("Common")) {
            holder.level.setTextColor(ContextCompat.getColor(context, R.color.common_blue));
        }
        if (lutemons.get(position).getLevel().equals("Rare")) {
            holder.level.setTextColor(ContextCompat.getColor(context, R.color.rare_purple));
        }
        if (lutemons.get(position).getLevel().equals("Epic")) {
            holder.level.setTextColor(ContextCompat.getColor(context, R.color.epic_Yellow));
        }

        changeCardColor(lutemons.get(position).getType(),holder);

        holder.exp.setText("Experience: " + Integer.toString(lutemons.get(position).getExperience()));
        holder.health.setText("Health: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMax_health());
        holder.attack.setText(lutemons.get(position).getAttack().getName() + ": " + lutemons.get(position).getAttack().getAmmmount() + " damage");
        holder.attack_rng.setText(lutemons.get(position).getAttack_rng().getName() + ": " + lutemons.get(position).getAttack_rng().getAmmmount_min() + " or " + lutemons.get(position).getAttack_rng().getAmmmount_max() + " damage");
        holder.defence.setText(lutemons.get(position).getDefense().getName() + ": " + lutemons.get(position).getDefense().getAmmmount() + " hp");


        if (!(lutemons.get(position).getLevel().equals("Epic"))){
            if (lutemons.get(position).getExperience() >= 30) {
                holder.levelUp.setVisibility(View.VISIBLE);
                holder.levelUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Lutemon levelUpLutemon = lutemons.get(holder.getAdapterPosition());
                        LutemonStorage.getInstance().getCurrentLutemons().remove(holder.getAdapterPosition());
                        LutemonStorage.getInstance().getCurrentLutemons().add(Home.getInstance().levelUp(levelUpLutemon));
                        holder.levelUp.setVisibility(View.GONE);
                        notifyDataSetChanged();
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    //"changeCardColor" switches the lutemon_views backround color to match it's type
    @SuppressLint("ResourceAsColor")
    public void changeCardColor(String type, LutemonViewHolder holder) {
        switch (type) {
            case "Cluster":
                holder.linearLayoutCompat.setBackgroundColor(ContextCompat.getColor(context, R.color.cluster_red));
                break;
            case "Enklaavi":
                holder.linearLayoutCompat.setBackgroundColor(ContextCompat.getColor(context, R.color.enklaavi_purple));
                break;
            case "Pelletti":
                holder.linearLayoutCompat.setBackgroundColor(ContextCompat.getColor(context, R.color.pelletti_green));
                break;
            case "KRK":
                holder.linearLayoutCompat.setBackgroundColor(ContextCompat.getColor(context, R.color.krk_orange));
                break;
            case "Satky":
                holder.linearLayoutCompat.setBackgroundColor(ContextCompat.getColor(context, R.color.satky_yellow));
                break;
            default:
                holder.linearLayoutCompat.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    public void updateData(ArrayList<Lutemon> newLutemons, int position) {
        lutemons = newLutemons;
        notifyItemInserted(position);
    }


}
