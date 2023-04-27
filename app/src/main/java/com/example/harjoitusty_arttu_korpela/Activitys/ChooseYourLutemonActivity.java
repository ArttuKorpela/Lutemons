/*
----------------------------------------------------------------------------------------------------
This Activity has a recyclerView that has buttons for each of your current lutemons as buttons
Pressing said button will activate the battleActivity
----------------------------------------------------------------------------------------------------
*/

package com.example.harjoitusty_arttu_korpela.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.R;
import com.example.harjoitusty_arttu_korpela.pickingRecyclerView.PickLutemonAdapter;

public class ChooseYourLutemonActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    LutemonStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_lutemon);

        recyclerView = findViewById(R.id.rbPickLutemon);
        storage = LutemonStorage.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new PickLutemonAdapter(this,storage.getCurrentLutemons()));



    }
}