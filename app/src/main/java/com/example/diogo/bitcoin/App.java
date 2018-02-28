package com.example.diogo.bitcoin;

import android.app.Application;

import com.example.diogo.bitcoin.data.repository.Repository;
import com.example.diogo.bitcoin.data.repository.local.DatabaseProvider;
import com.example.diogo.bitcoin.data.repository.local.LocalDataCharts;
import com.example.diogo.bitcoin.data.repository.remote.APIClient;
import com.example.diogo.bitcoin.data.repository.remote.APIService;
import com.example.diogo.bitcoin.data.repository.remote.RemoteDataCharts;

/**
 * Created by Diogo on 2/27/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseProvider.init(this);
    }

    public static Repository getRepository() {
        return Repository.getInstance(RemoteDataCharts.getInstance(APIClient.getClient()), LocalDataCharts.getInstance());
    }

}
