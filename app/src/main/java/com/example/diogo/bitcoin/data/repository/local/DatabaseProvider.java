package com.example.diogo.bitcoin.data.repository.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.diogo.bitcoin.data.repository.local.contract.ChartContract;

/**
 * Created by Diogo on 2/27/2018.
 */

public class DatabaseProvider {
    private static Database database;

    private DatabaseProvider() {}

    public static void init(Context context) {
        database = new Database(context, "bitcoin.db");
    }

    public static SQLiteDatabase getReadableDatabase() {
        return database.getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDatabase() {
        return database.getWritableDatabase();
    }

    public static void clearTables() {
        getWritableDatabase().execSQL("DELETE FROM " + ChartContract.TABLE_NAME);
    }

    public static void initDatabaseInMemory(Context context) {
        database = new Database(context, null);
    }
}
