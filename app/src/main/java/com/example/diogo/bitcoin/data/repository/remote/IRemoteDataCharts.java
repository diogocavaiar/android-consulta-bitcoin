package com.example.diogo.bitcoin.data.repository.remote;

import android.support.annotation.NonNull;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.model.StatsResponse;
import com.example.diogo.bitcoin.data.repository.IDataCharts;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface IRemoteDataCharts extends IDataCharts {

    void getCharts(@NonNull LoadDataCallback<Charts> callback);

    void getStats(@NonNull LoadDataCallback<StatsResponse> callback);
}
