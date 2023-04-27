package com.example.harjoitusty_arttu_korpela.fallenRecyclerView;

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
import com.example.harjoitusty_arttu_korpela.OnItemClick;
import com.example.harjoitusty_arttu_korpela.R;

import java.util.ArrayList;

public class FallenLutemonAdapter extends RecyclerView.Adapter<FallenLutemonHolder> {


    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    private OnItemClick mCallback;


    public FallenLutemonAdapter(Context context, ArrayList<Lutemon> lutemons, OnItemClick listener) {
        this.context = context;
        this.lutemons = lutemons;
        this.mCallback = listener;
    }

    @NonNull
    @Override
    public FallenLutemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FallenLutemonHolder(LayoutInflater.from(context).inflate(R.layout.fallen_view,parent,false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull FallenLutemonHolder holder, int position) {

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


        holder.revive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lutemon lutemon = lutemons.get(holder.getAdapterPosition());
                lutemon.setHealth(lutemon.getMax_health());
                LutemonStorage.getInstance().addLutemon(lutemon);

                lutemons.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                //reduce kelabucks
                Home.getInstance().setKela_bucks(Home.getInstance().getKela_bucks()-100);
                mCallback.onClick("test"); //Notifies the interface of the onClick event to update the money counter


            }
        });

    }


    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    //"changeCardColor" switches the lutemon_views backround color to match it's type
    @SuppressLint("ResourceAsColor")
    public void changeCardColor(String type, FallenLutemonHolder holder) {
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

}
