package com.example.farmbot;

import com.google.gson.annotations.SerializedName;

public class ModelClass {
    @SerializedName("temperature")
    private String temperature;

    public String getSensorData() {
        return temperature;
    }
}