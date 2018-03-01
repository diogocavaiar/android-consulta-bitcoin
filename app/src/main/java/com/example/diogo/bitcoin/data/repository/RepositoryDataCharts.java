package com.example.diogo.bitcoin.data.repository;

import android.support.annotation.NonNull;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.model.StatsResponse;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface RepositoryDataCharts {

    void getCharts(@NonNull IDataCharts.LoadDataCallback<Charts> callback, boolean isNetworkAvailable);

    void saveCharts(@NonNull List<Charts> value);

    void deleteAllCharts();

    void getStats(@NonNull IDataCharts.LoadDataCallback<StatsResponse> callback, boolean isNetworkAvailable);

}
