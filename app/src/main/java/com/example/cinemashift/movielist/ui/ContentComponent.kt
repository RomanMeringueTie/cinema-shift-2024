package com.example.cinemashift.movielist.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.cinemashift.common.data.model.Movie

@Composable
fun ContentComponent(movieItems: List<Movie>, onItemSelected: (id: String) -> Unit)
{
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        items(movieItems) {
            MovieCard(movieItem = it, onItemSelected)
        }
    }
}