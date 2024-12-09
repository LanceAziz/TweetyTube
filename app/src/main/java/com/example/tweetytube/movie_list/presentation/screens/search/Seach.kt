package com.example.tweetytube.movie_list.presentation.screens.search

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

@Composable
fun Search(nav){

    TextField(
        value = "",
        onValueChange = { },
        label = {Text("Search")},
    )
}