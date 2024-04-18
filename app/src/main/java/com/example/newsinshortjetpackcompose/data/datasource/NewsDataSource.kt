package com.example.newsinshortjetpackcompose.data.datasource

import com.example.newsinshortjetpackcompose.data.model.NewsResponseModel
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadLine(country: String): Response<NewsResponseModel>
}