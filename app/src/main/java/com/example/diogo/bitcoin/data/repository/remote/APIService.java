package com.example.diogo.bitcoin.data.repository.remote;

import com.example.diogo.bitcoin.data.model.ChartsResponse;
import com.example.diogo.bitcoin.data.model.StatsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface APIService {

    @GET("charts/transactions-per-second/")
    Call<ChartsResponse> getCharts(@Query("timespan") String timespan);

    @GET("stats")
    Call<StatsResponse> getStats();
}