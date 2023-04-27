/*
----------------------------------------------------------------------------------------------------
This is the main view of the application. It's the first view the person sees when opening the app.

Components:

Buttons: "lutemons" takes you to the lutemonsTabAvtivity where the most of the operations regarding
lutemons are done.

"fight" takes you to the arenaActivity, where the fighting between lutemons happens.

"stats" takes you to look at the statistics.

----------------------------------------------------------------------------------------------------
*/
package com.example.harjoitusty_arttu_korpela.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.harjoitusty_arttu_korpela.R;

public class MainActivity extends AppCompatActivity {
    Button lutemons;
    Button fight;
    Button stats;

    ImageView settings;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lutemons = findViewById(R.id.btnLutemons);
        fight = findViewById(R.id.btnArena);
        stats = findViewById(R.id.btnStatistics);
        settings = findViewById(R.id.imgSettings);

        lutemons.setOnClickListener(listener);
        fight.setOnClickListener(listener);
        stats.setOnClickListener(listener);
        settings.setOnClickListener(listener);






    }

    private OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnLutemons:
                    Intent intentLutemons = new Intent(view.getContext(), LutemonsTabActivity.class);
                    startActivity(intentLutemons);

                    break;
                case R.id.btnArena:
                    Intent intentArena = new Intent(view.getContext(),ChooseYourLutemonActivity.class);
                    startActivity(intentArena);
                    break;
                case R.id.btnStatistics:
                    Intent intentStats = new Intent(view.getContext(),PickChartActivity.class);
                    startActivity(intentStats);
                    break;
                case R.id.imgSettings:
                    Intent intentSettings = new Intent(view.getContext(),SettingsActivity.class);
                    startActivity(intentSettings);

            }
        }
    };
}