package com.example.diogo.bitcoin.data.repository.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diogo.bitcoin.data.repository.local.contract.ChartContract;

/**
 * Created by Diogo on 2/27/2018.
 */

public class Database extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    public Database(Context context, String name) {
        super(context, name, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ")
                .append(ChartContract.TABLE_NAME).append(" ( ")
                .append(ChartContract._ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ")
                .append(ChartContract.COLUMN_X).append(" NUMERIC, ")
                .append(ChartContract.COLUMN_Y).append(" NUMERIC ")
                .append(") ");

        sqLiteDatabase.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
