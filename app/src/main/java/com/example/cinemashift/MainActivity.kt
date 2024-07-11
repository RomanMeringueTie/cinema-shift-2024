package com.example.cinemashift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cinemashift.main.ui.MainScreen
import com.example.cinemashift.ui.theme.CinemaShiftTheme
import com.example.cinemashift.movielist.data.ui.MovieListScreen
import com.example.cinemashift.movielist.domain.usecase.GetMovieListUseCase
import com.example.cinemashift.movielist.presentation.MovieListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaShiftTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}