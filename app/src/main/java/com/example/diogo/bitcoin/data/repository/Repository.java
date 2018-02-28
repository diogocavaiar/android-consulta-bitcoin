package com.example.diogo.bitcoin.data.repository;

import android.support.annotation.NonNull;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.repository.local.LocalDataCharts;
import com.example.diogo.bitcoin.data.repository.remote.RemoteDataCharts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public class Repository implements RepositoryDataCharts {

    private static Repository INSTANCE = null;

    private RemoteDataCharts remoteDataSource;
    private LocalDataCharts localDataSource;

    public static Repository getInstance(RemoteDataCharts remoteDataSource, LocalDataCharts localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(remoteDataSource, localDataSource);
        }
        return INSTANCE;
    }

    private Repository(@NonNull RemoteDataCharts remoteDataSource, @NonNull LocalDataCharts localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getCharts(@NonNull IDataCharts.LoadDataCallback<Charts> callback, boolean isNetworkAvailable) {
        if (isNetworkAvailable){
            getChartsFromRemoteDataSource(callback);
        } else {
            getChartsFromLocalDataSource(callback);
        }
    }

    @Override
    public void saveCharts(@NonNull List<Charts> value) {
        localDataSource.insert(value);
    }

    @Override
    public void deleteAllCharts() {
        localDataSource.deleteAll();
    }

    private void getChartsFromRemoteDataSource(final IDataCharts.LoadDataCallback<Charts> callback) {
        remoteDataSource.getCharts(new IDataCharts.LoadDataCallback<Charts>() {
            @Override
            public void onDataLoaded(List<Charts> list) {
                refreshChartsLocalDataSource(list);
                callback.onDataLoaded(new ArrayList<>(list));
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    private void getChartsFromLocalDataSource(final IDataCharts.LoadDataCallback<Charts> callback) {
        callback.onDataLoaded(localDataSource.getAll());
    }

    private void refreshChartsLocalDataSource(List<Charts> list) {
        localDataSource.deleteAll();
        localDataSource.insert(list);
    }
}
