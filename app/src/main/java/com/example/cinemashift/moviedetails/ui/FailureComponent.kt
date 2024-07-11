package com.example.cinemashift.moviedetails.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinemashift.R

@Composable
fun FailureComponent(message: String, onRetry: () -> Unit)
{
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(id = R.string.movie_details_failure)) },
        text = { Text(text = message) },
        confirmButton = {
            Button(onClick = onRetry) {
                Text(text = stringResource(id = R.string.try_again))
            }
        },
        modifier = Modifier
    )
}