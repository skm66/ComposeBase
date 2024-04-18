package com.example.newsinshortjetpackcompose.data.datasource

import com.example.newsinshortjetpackcompose.data.endpoint.ApiService
import com.example.newsinshortjetpackcompose.data.model.NewsResponseModel
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {

    override suspend fun getNewsHeadLine(country: String): Response<NewsResponseModel> {
        return apiService.getNewsHeadLine(country)
    }

}