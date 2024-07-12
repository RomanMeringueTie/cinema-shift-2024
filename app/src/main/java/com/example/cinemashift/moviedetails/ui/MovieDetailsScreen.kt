package com.example.cinemashift.moviedetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinemashift.R
import com.example.cinemashift.moviedetails.presentation.MovieDetailsViewModel
import com.example.cinemashift.moviedetails.presentation.MovieItemState

@Composable
fun MovieDetailScreen(movieId: String, viewModel: MovieDetailsViewModel)
{
    val movieItemState by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadById(movieId)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)  {
        when (val state = movieItemState) {
            is MovieItemState.Initial,
            is MovieItemState.Loading -> LoadingComponent()
            is MovieItemState.Content -> ContentComponent(movieItem = state.movieItem)
            is MovieItemState.Failure -> FailureComponent(message = state.message ?: stringResource(id = R.string.movie_list_failure), {viewModel.loadById(movieId)})
        }

    }
}