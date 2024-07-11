package com.example.cinemashift.movielist.data.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.cinemashift.R
import com.example.cinemashift.movielist.presentation.MovieListState
import com.example.cinemashift.movielist.presentation.MovieListViewModel
import com.example.cinemashift.movielist.ui.ContentComponent
import com.example.cinemashift.movielist.ui.FailureComponent
import com.example.cinemashift.movielist.ui.LoadingComponent

@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel,
    onItemSelected: (id: String) -> Unit
)
{
    val movieListState by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadList()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)  {
        Text(
            text = stringResource(id = R.string.movie_list_header),
            fontSize = 40.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        when (val state = movieListState) {
            is MovieListState.Initial,
            is MovieListState.Loading -> LoadingComponent()
            is MovieListState.Content -> ContentComponent(movieItems = state.movieListItem.films, onItemSelected)
            is MovieListState.Failure -> FailureComponent(message = state.message ?: stringResource(id = R.string.movie_list_failure), {viewModel.loadList()})
        }

    }
}
