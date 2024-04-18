package com.example.newsinshortjetpackcompose.ui.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsinshortjetpackcompose.data.datasource.NewsDataSource
import com.example.newsinshortjetpackcompose.data.model.NewsResponseModel
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {


    suspend fun getNewsHeadLine(country: String): Flow<ResourceState<NewsResponseModel>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getNewsHeadLine(country)
            Log.e("aaa", "getNewsHeadLine: $response ")
            if (response.isSuccessful) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "some error in flow"))

        }
    }



}
