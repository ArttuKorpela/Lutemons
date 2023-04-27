package com.example.harjoitusty_arttu_korpela.fragmentsLutemons;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.FallenLutemonStorage;
import com.example.harjoitusty_arttu_korpela.FragmentUpdater;
import com.example.harjoitusty_arttu_korpela.HealingTimer;
import com.example.harjoitusty_arttu_korpela.Home;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.OnItemClick;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.fallenRecyclerView.FallenLutemonAdapter;

import java.util.Timer;


public class FallenLutemonsFragment extends Fragment implements OnItemClick {


    RecyclerView recyclerView;
    TextView kelabucks;
    FallenLutemonStorage storage;

    FragmentUpdater fragmentUpdater;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentUpdater = new ViewModelProvider(requireActivity()).get(FragmentUpdater.class);
        fragmentUpdater.getValue().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                kelabucks.setText(Integer.toString(Home.getInstance().getKela_bucks()));
            }
        });

        View view = inflater.inflate(R.layout.fragment_fallen_lutemons, container, false);
        kelabucks = view.findViewById(R.id.textViewKelaBucks);
        kelabucks.setText(Integer.toString(Home.getInstance().getKela_bucks()));
        recyclerView = view.findViewById(R.id.rvFallenLutemons);
        storage = FallenLutemonStorage.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new FallenLutemonAdapter(getContext(),storage.getCurrentLutemons(),this));
        Timer timer = new Timer();
        timer.schedule(new HealingTimer(), 0, 60000);
        checkHealed();


        return view;
    }

    @Override
    public void onClick(String value) {
        if (value.equals("test")) {
            fragmentUpdater.update();
        }
    }

    public void checkHealed() {
        int n = 0;
        for (Lutemon healable : storage.getCurrentLutemons()) {
            if (healable.getHealth() == healable.getMax_health()) {
                storage.getCurrentLutemons().remove(n);
                LutemonStorage.getInstance().addLutemon(healable);
            }
            n++;
        }
    }
}