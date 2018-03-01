package com.example.diogo.bitcoin.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public class Charts {

    @SerializedName("x")
    private long x;
    @SerializedName("y")
    private float y;

    public Charts(final long x, final float y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
