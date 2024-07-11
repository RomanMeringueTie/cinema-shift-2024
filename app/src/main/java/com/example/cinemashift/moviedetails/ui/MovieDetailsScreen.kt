package com.example.cinemashift.moviedetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemashift.R
import com.example.cinemashift.moviedetails.presentation.MovieDetailViewModel
import com.example.cinemashift.moviedetails.presentation.MovieItemState

@Composable
fun MovieDetailScreen(movieId: String, viewModel: MovieDetailViewModel)
{
    val movieItemState by viewModel.state.collectAsState()
    viewModel.loadById(movieId)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)  {
        Spacer(modifier = Modifier.size(50.dp))
        when (val state = movieItemState) {
            is MovieItemState.Initial,
            is MovieItemState.Loading -> LoadingComponent()
            is MovieItemState.Content -> ContentComponent(movieItem = state.movieItem)
            is MovieItemState.Failure -> FailureComponent(message = state.message ?: stringResource(id = R.string.movie_list_failure), {viewModel.loadById(movieId)})
        }

    }
}