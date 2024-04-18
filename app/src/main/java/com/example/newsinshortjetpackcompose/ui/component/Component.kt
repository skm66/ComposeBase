package com.example.newsinshortjetpackcompose.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsinshortjetpackcompose.data.model.NewsResponseModel
import com.example.newsinshortjetpackcompose.ui.theme.purple_color

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp), color = purple_color
        )
    }


}


@Composable
fun ShowNewsList(response: NewsResponseModel) {
    LazyColumn {
        items(response.articles) { article ->
            NormalTextView(textValue = article.title ?: "Not Available")
        }
    }

}

@Composable
fun NormalTextView(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
    )
}