package com.example.farmbot;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("sensordData")
    private String sensordData;

    private String getSensordData() {return sensordData;}
}
