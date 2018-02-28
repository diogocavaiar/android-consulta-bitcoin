package com.example.diogo.bitcoin.data.repository.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.model.ChartsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Diogo on 2/27/2018.
 */

public class RemoteDataCharts implements IRemoteDataCharts {

    private static final String LOG_TAG = RemoteDataCharts.class.getSimpleName();

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
        Call<ChartsResponse> articleResponseCall = service.getCharts();
        articleResponseCall.enqueue(new Callback<ChartsResponse>() {
            @Override
            public void onResponse(final Call<ChartsResponse> call, final Response<ChartsResponse> response) {
                if ("ok".equals(response.body().getStatus())){
                    if (!response.body().getValues().isEmpty()) {
                        callback.onDataLoaded(response.body().getValues());
                    } else {
                        Log.e(LOG_TAG, "Oops, something went wrong!");
                    }
                } else {
                    Log.e(LOG_TAG, "Oops, something went wrong!");
                }
            }

            @Override
            public void onFailure(Call<ChartsResponse> call, Throwable t) {
                Log.e(LOG_TAG, "Error:" + t.getMessage());
            }
        });
    }
}
