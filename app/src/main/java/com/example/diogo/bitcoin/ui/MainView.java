package com.example.diogo.bitcoin.ui;

import android.support.annotation.NonNull;

import com.example.diogo.bitcoin.data.model.Charts;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface MainView {

    void showSources(@NonNull List<Charts> list);

    void setRefreshing(boolean refreshing);

    boolean isNetworkAvailable();

    void showLoadingChartError();

    void showNoChartData();

}
