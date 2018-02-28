package com.example.diogo.bitcoin.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public class Charts {

    @SerializedName("x")
    private double x;
    @SerializedName("y")
    private double y;

    public Charts(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
