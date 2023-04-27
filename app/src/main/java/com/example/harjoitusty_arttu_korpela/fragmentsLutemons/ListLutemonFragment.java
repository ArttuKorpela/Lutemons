package com.example.harjoitusty_arttu_korpela.fragmentsLutemons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.FragmentUpdater;
import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.lutemonRecyclerView.lutemonViewAdapter;

public class ListLutemonFragment extends Fragment  {

    LutemonStorage storage;
    RecyclerView recyclerView;
    FragmentUpdater fragmentUpdater;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentUpdater = new ViewModelProvider(requireActivity()).get(FragmentUpdater.class);

        fragmentUpdater.getValue().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                storage = LutemonStorage.getInstance();
                lutemonViewAdapter adapter = new lutemonViewAdapter(getContext(), storage.getCurrentLutemons());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

        });



        View view = inflater.inflate(R.layout.fragment_list_lutemon, container, false);
        recyclerView = view.findViewById(R.id.RecyclerViewListLutemons);
        storage = LutemonStorage.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new lutemonViewAdapter(getContext(),storage.getCurrentLutemons()));

        return view;
    }

}