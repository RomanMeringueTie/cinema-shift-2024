package com.example.cinemashift.main.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinemashift.movielist.MovieListRoute
import com.example.cinemashift.movielist.data.ui.MovieListScreen
import com.example.cinemashift.movielist.domain.usecase.GetMovieListUseCase
import com.example.cinemashift.movielist.presentation.MovieListViewModel

@Composable
fun MainScreen()
{
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = "history") {
            composable("history") {
                MovieListScreen(viewModel = MovieListViewModel(GetMovieListUseCase()))
            }
            composable("details") {
//                val destination = it.toRoute<DetailsRoute>()
//                DetailsScreen(
//                    viewModel = koinViewModel { parametersOf(destination.loanId) },
//                )
            }
        }
    }
}