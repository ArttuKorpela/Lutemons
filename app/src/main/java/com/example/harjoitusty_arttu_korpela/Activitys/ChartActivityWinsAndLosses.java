/*
----------------------------------------------------------------------------------------------------
This Activity is to present the pie chart of how wins and losses compare to each other
----------------------------------------------------------------------------------------------------
*/
package com.example.harjoitusty_arttu_korpela.Activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.example.harjoitusty_arttu_korpela.Counter;
import com.example.harjoitusty_arttu_korpela.R;

import java.util.ArrayList;
import java.util.List;

public class ChartActivityWinsAndLosses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_wins_and_losses);

        Pie pieWinAndLosses = AnyChart.pie();

        List<DataEntry> dataWinLoss = new ArrayList<>();

        dataWinLoss.add(new ValueDataEntry("Wins", Counter.getWins()));
        dataWinLoss.add(new ValueDataEntry("Losses", Counter.getLosses()));

        pieWinAndLosses.data(dataWinLoss);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        AnyChartView winsLosses = (AnyChartView) findViewById(R.id.any_chart_view_2);

        winsLosses.setChart(pieWinAndLosses);
    }
}