package com.example.cinemashift.movielist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.google.android.material.progressindicator.CircularProgressIndicator

@Composable
fun LoadingComponent()
{
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}