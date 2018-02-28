package com.example.diogo.bitcoin.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Diogo on 2/27/2018.
 */

public class ChartsResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("name")
    private String name;
    @SerializedName("unit")
    private String unit;
    @SerializedName("period")
    private String period;
    @SerializedName("description")
    private String description;
    @SerializedName("values")
    private List<Charts> values;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Charts> getValues() {
        return values;
    }

    public void setValues(List<Charts> values) {
        this.values = values;
    }

}
