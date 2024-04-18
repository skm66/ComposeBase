package com.example.newsinshortjetpackcompose.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshortjetpackcompose.ui.component.Loader
import com.example.newsinshortjetpackcompose.ui.component.ShowNewsList
import com.example.newsinshortjetpackcompose.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState


const val TAG = "HomeScreen"
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsResponse by newsViewModel.news.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        when (newsResponse) {
            is ResourceState.Loading -> {
                Log.d(TAG, "HomeScreen: Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsResponse as ResourceState.Success).data
                Log.d(TAG, "HomeScreen: status = ${response.status} ${response.totalResults}")
                ShowNewsList(response = response)
            }

            is ResourceState.Error -> {
                Log.d(TAG, "HomeScreen: error")
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}