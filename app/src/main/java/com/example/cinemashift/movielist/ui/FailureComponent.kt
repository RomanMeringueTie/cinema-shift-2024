package com.example.cinemashift.movielist.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinemashift.R
import com.example.cinemashift.movielist.presentation.MovieListState

@Composable
fun FailureComponent(message: String, onRetry: () -> Unit)
{
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(id = R.string.movie_list_failure)) },
        text = { Text(text = message) },
        confirmButton = {
            Button(onClick = onRetry) {
                Text(text = stringResource(id = R.string.movie_list_try_again))
            }
        },
        modifier = Modifier
    )
}