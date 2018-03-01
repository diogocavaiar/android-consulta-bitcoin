package com.example.diogo.bitcoin.ui;

import com.example.diogo.bitcoin.data.model.StatsResponse;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface MainPresenter {

    void loadCharts();

    void loadListStats();

    ArrayList<String> getValuesX();

    List<Entry> getValuesY();
}
