package com.example.diogo.bitcoin.ui;

import android.support.annotation.NonNull;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.model.StatsResponse;
import com.example.diogo.bitcoin.data.repository.IDataCharts;
import com.example.diogo.bitcoin.data.repository.RepositoryDataCharts;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public class MainPresenterImpl implements MainPresenter {
    private final List<Entry> yVals;
    private final RepositoryDataCharts repository;
    private final MainView view;

    public MainPresenterImpl(@NonNull RepositoryDataCharts repository, @NonNull MainView view) {
        yVals = new ArrayList<Entry>();
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void loadCharts() {
        loadChartsFromRepository(view.isNetworkAvailable());
        loadListStats();
    }

    @Override
    public void loadListStats() {
        repository.getStats(new IDataCharts.LoadDataCallback<StatsResponse>() {

            @Override
            public void onDataLoaded(final List<StatsResponse> list) {
                if(list == null || list.isEmpty()) {
                    view.showNoChartData();
                }
                view.showInfoCard(list);
            }

            @Override
            public void onDataNotAvailable() {
                view.showLoadingChartError();
            }
        }, view.isNetworkAvailable());
    }

    @Override
    public ArrayList<String> getValuesX() {
        final ArrayList<String> xVals = new ArrayList<>();
        for(int i = 0; i < yVals.size(); i++) {
            xVals.add(String.valueOf(i));
        }
        return xVals;
    }

    @Override
    public List<Entry> getValuesY() {
        return yVals;
    }

    private void loadChartsFromRepository(final boolean isNetworkAvailable) {
        view.showProgress();

        repository.getCharts(new IDataCharts.LoadDataCallback<Charts>() {

            @Override
            public void onDataLoaded(final List<Charts> list) {
                if(list == null || list.isEmpty()) {
                    view.showNoChartData();
                }

                for(int i = 0; i < list.size(); i++) {
                    yVals.add(new Entry(list.get(i).getY(), i));
                }

                view.showCharts(yVals);
                view.setUpChart();
                view.hideProgress();
            }

            @Override
            public void onDataNotAvailable() {
                view.showLoadingChartError();
            }
        }, isNetworkAvailable);
    }
}
