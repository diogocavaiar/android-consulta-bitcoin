package com.example.diogo.bitcoin.ui;

import android.support.annotation.NonNull;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.model.StatsResponse;
import com.github.mikephil.charting.data.Entry;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface MainView {

    void showCharts(@NonNull List<Entry> list);

    void showInfoCard(@NonNull List<StatsResponse> list);

    void setUpChart();

    void showProgress();

    void hideProgress();

    boolean isNetworkAvailable();

    void showLoadingChartError();

    void showNoChartData();

}
