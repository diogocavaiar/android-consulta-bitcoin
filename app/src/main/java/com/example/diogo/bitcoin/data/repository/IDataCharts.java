package com.example.diogo.bitcoin.data.repository;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public interface IDataCharts {

    interface LoadDataCallback<T> {

        void onDataLoaded(final List<T> list);

        void onDataNotAvailable();
    }
}
