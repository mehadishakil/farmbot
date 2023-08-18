package com.example.farmbot

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login_user.php")
    suspend fun loginUser(@Body postData: PostData): Response<ApiResponse>

    @POST("signup_user.php")
    suspend fun registerUser(@Body postData: PostData): Response<ApiResponse>
}