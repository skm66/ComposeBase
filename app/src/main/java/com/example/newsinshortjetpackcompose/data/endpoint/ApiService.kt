package com.example.newsinshortjetpackcompose.data.endpoint

import com.example.newsinshortjetpackcompose.data.model.NewsResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadLine(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "1bf29c3f359c442b8e8714885c694ff6",
    ): Response<NewsResponseModel>
}