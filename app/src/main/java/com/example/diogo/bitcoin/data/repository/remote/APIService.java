package com.example.diogo.bitcoin.data.repository.remote;

import com.example.diogo.bitcoin.data.model.ChartsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface APIService {

    @GET("charts/transactions-per-second")
    Call<ChartsResponse> getCharts();

}
