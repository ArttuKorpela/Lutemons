/*
----------------------------------------------------------------------------------------------------
This Activity has only two buttons:
    - lutemonWins, starts the chartActivity
    - winsLosses, starts the chartActivityWinsAndLosses
----------------------------------------------------------------------------------------------------
*/

package com.example.harjoitusty_arttu_korpela.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.harjoitusty_arttu_korpela.R;

public class PickChartActivity extends AppCompatActivity {

    Button lutemonWins, winsLosses;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_chart);

        lutemonWins = findViewById(R.id.btnLutemonWins);
        winsLosses = findViewById(R.id.btnWinsLosses);

        lutemonWins.setOnClickListener(listener);
        winsLosses.setOnClickListener(listener);


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnLutemonWins:
                    Intent intentLutemonsWins = new Intent(view.getContext(),ChartActivity.class);
                    startActivity(intentLutemonsWins);
                    break;
                case R.id.btnWinsLosses:
                    Intent intentWinsLosses = new Intent(view.getContext(),ChartActivityWinsAndLosses.class);
                    startActivity(intentWinsLosses);
                    break;
            }
        }
    };
}