package com.example.diogo.bitcoin.ui;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.diogo.bitcoin.App;
import com.example.diogo.bitcoin.R;
import com.example.diogo.bitcoin.data.model.Charts;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        presenter.loadCharts();
    }

    private void initPresenter() {
        presenter = new MainPresenterImpl(App.getRepository(),this);
    }

    @Override
    public void showSources(@NonNull List<Charts> list) {

    }

    @Override
    public void setRefreshing(boolean refreshing) {

    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager  = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void showLoadingChartError() {
        Snackbar.make(findViewById(android.R.id.content), "Had a snack at Snackbar", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showNoChartData() {

    }
}
