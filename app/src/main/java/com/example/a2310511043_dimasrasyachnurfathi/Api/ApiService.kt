package com.example.a2310511043_dimasrasyachnurfathi.Api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("recipes")
    fun getAllResep(): Call<ApiResponse>
}