/*
----------------------------------------------------------------------------------------------------
This Activity has only two buttons:
    - load, loads your saved lutemons
    - save, saves your current alive lutemons
----------------------------------------------------------------------------------------------------
*/
package com.example.harjoitusty_arttu_korpela.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.R;

public class SettingsActivity extends AppCompatActivity {

    Button load, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        load = findViewById(R.id.btnLoadLutemons);
        save = findViewById(R.id.btnSaveLutemons);

        load.setOnClickListener(listener);
        save.setOnClickListener(listener);


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnLoadLutemons:
                    LutemonStorage.getInstance().loadLutemon(getApplicationContext());
                    break;
                case R.id.btnSaveLutemons:
                    LutemonStorage.getInstance().saveLutemons(getApplicationContext());
                    break;
            }
        }
    };
}