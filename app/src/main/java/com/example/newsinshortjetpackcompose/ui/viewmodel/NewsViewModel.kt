package com.example.newsinshortjetpackcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsinshortjetpackcompose.data.AppConstants
import com.example.newsinshortjetpackcompose.data.model.NewsResponseModel
import com.example.newsinshortjetpackcompose.ui.repository.NewsRepository
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news :  MutableStateFlow<ResourceState<NewsResponseModel>> = MutableStateFlow(ResourceState.Loading())
    val news : StateFlow<ResourceState<NewsResponseModel>> = _news

    init {
        getNews(AppConstants.COUNTRY)
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadLine(country).collectLatest { newsResponse ->
                _news.value = newsResponse
            }
        }
    }


}