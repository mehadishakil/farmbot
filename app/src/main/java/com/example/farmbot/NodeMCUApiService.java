package com.example.farmbot;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NodeMCUApiService {
    @GET("/GetData")
    Call<ModelClass> getDataFromNodeMCU();


}
