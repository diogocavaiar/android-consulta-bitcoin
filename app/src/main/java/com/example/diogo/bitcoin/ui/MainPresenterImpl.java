package com.example.diogo.bitcoin.ui;

import android.support.annotation.NonNull;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.repository.IDataCharts;
import com.example.diogo.bitcoin.data.repository.RepositoryDataCharts;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public class MainPresenterImpl implements MainPresenter {

    private final RepositoryDataCharts repository;
    private final MainView view;

    public MainPresenterImpl(@NonNull RepositoryDataCharts repository, @NonNull MainView view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void loadCharts() {
        loadChartsFromRepository(view.isNetworkAvailable());
    }

    private void loadChartsFromRepository(final boolean isNetworkAvailable) {
        view.setRefreshing(true);

        repository.getCharts(new IDataCharts.LoadDataCallback<Charts>() {

            @Override
            public void onDataLoaded(final List<Charts> list) {
                if(list == null || list.isEmpty()) {
                    view.showNoChartData();
                }
                view.showSources(list);
                view.setRefreshing(false);
            }

            @Override
            public void onDataNotAvailable() {
                view.showLoadingChartError();
            }
        }, isNetworkAvailable);
    }
}
