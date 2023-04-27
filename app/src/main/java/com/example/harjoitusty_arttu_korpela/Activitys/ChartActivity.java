/*
----------------------------------------------------------------------------------------------------
This Activity is to present the pie chart of how the wins are distributed between lutemons
----------------------------------------------------------------------------------------------------
*/

package com.example.harjoitusty_arttu_korpela.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.example.harjoitusty_arttu_korpela.FallenLutemonStorage;
import com.example.harjoitusty_arttu_korpela.Lutemon;
import com.example.harjoitusty_arttu_korpela.LutemonStorage;
import com.example.harjoitusty_arttu_korpela.R;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Pie pie = AnyChart.pie();


        List<DataEntry> data = new ArrayList<>();

        //Goes through all the current alive lutemons
        for (Lutemon lutemon: LutemonStorage.getInstance().getCurrentLutemons()) {
            int wins = lutemon.getWins();
            String name = lutemon.getNickname();
            data.add(new ValueDataEntry(name,wins));
        }
        //Goes through all fallen lutemons
        for (Lutemon lutemon: FallenLutemonStorage.getInstance().getCurrentLutemons()) {
            int wins = lutemon.getWins();
            String name = lutemon.getNickname();
            data.add(new ValueDataEntry(name,wins));
        }

        pie.data(data);

        AnyChartView lutemonWins = (AnyChartView) findViewById(R.id.any_chart_view);

        lutemonWins.setChart(pie);

    }
}