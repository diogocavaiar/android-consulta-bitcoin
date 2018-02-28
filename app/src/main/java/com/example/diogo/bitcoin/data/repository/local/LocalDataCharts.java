package com.example.diogo.bitcoin.data.repository.local;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.diogo.bitcoin.data.model.Charts;
import com.example.diogo.bitcoin.data.repository.local.contract.ChartContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public class LocalDataCharts implements ILocalDataRepository<Charts> {

    private static LocalDataCharts INSTANCE;

    public static LocalDataCharts getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataCharts();
        }
        return INSTANCE;
    }

    @Override
    public List<Charts> getAll() {
        List<Charts> modelList = new ArrayList<>();

        Cursor cursor = DatabaseProvider.getReadableDatabase().query(ChartContract.TABLE_NAME, new String[]{ChartContract.COLUMN_X, ChartContract.COLUMN_Y},
                        null,
                        null,
                        null,
                        null,
                        null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                modelList.add(new Charts(cursor.getDouble(cursor.getColumnIndex(ChartContract.COLUMN_X)), cursor.getDouble(cursor.getColumnIndex(ChartContract.COLUMN_Y))));
            }
            cursor.close();
        }
        return modelList;
    }

    @Override
    public long insert(final List<Charts> charts) {
        ContentValues cv = new ContentValues();
        for(final Charts chart : charts) {
            cv.put(ChartContract.COLUMN_X, chart.getX());
            cv.put(ChartContract.COLUMN_Y, chart.getY());
        }
        return DatabaseProvider.getReadableDatabase().insert(ChartContract.TABLE_NAME, null, cv);
    }

    @Override
    public int deleteAll() {
        return DatabaseProvider.getWritableDatabase().delete(ChartContract.TABLE_NAME, null, null);
    }

}
