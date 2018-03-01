package com.example.diogo.bitcoin.data.repository.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.model.ChartsResponse;
import com.example.diogo.bitcoin.data.model.StatsResponse;
import com.example.diogo.bitcoin.data.repository.IDataCharts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Diogo on 2/27/2018.
 */

public class RemoteDataCharts implements IRemoteDataCharts {

    private static RemoteDataCharts INSTANCE;
    private APIService service;

    private RemoteDataCharts(APIService service) {
        this.service = service;
    }

    public static RemoteDataCharts getInstance(APIService service) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataCharts(service);
        }
        return INSTANCE;
    }

    @Override
    public void getCharts(@NonNull final LoadDataCallback<Charts> callback) {
        Call<ChartsResponse> chartsResponseCall = service.getCharts("2weeks");
        chartsResponseCall.enqueue(new Callback<ChartsResponse>() {
            @Override
            public void onResponse(@NonNull final Call<ChartsResponse> call, @NonNull final Response<ChartsResponse> response) {
                if(response != null) {
                    if (response.isSuccessful()){
                        if(response.body() != null) {
                            if (response.body().getValues() != null && !response.body().getValues().isEmpty()) {
                                callback.onDataLoaded(response.body().getValues());
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ChartsResponse> call, Throwable t) {
            }
        });
    }

    @Override
    public void getStats(@NonNull final LoadDataCallback<StatsResponse> callback) {
        Call<StatsResponse> statsResponseCall = service.getStats();
        statsResponseCall.enqueue(new Callback<StatsResponse>() {
            @Override
            public void onResponse(@NonNull final Call<StatsResponse> call, @NonNull final Response<StatsResponse> response) {
                if(response != null) {
                    if (response.isSuccessful()){
                        if(response.body() != null) {
                            if (response.body() != null) {
                                final StatsResponse stats = response.body();
                                final List<StatsResponse> list = new ArrayList<>();
                                list.add(stats);
                                callback.onDataLoaded(list);
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<StatsResponse> call, Throwable t) {
            }
        });
    }
}
