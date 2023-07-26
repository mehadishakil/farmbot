package com.example.farmbot;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.4.1/";

    // Create a custom OkHttpClient with a timeout
    OkHttpClient client = new OkHttpClient.Builder()
            .callTimeout(2, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();


    public RetrofitClientInstance() {
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public NodeMCUApiService getApiService() {
        return retrofit.create(NodeMCUApiService.class);
    }
}

