package com.example.cinemashift.main.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cinemashift.main.ui.presentation.MainViewModel
import com.example.cinemashift.moviedetails.domain.usecase.GetMovieByIdUseCase
import com.example.cinemashift.moviedetails.presentation.MovieDetailViewModel
import com.example.cinemashift.moviedetails.presentation.MovieItemState
import com.example.cinemashift.moviedetails.ui.MovieDetailScreen
import com.example.cinemashift.movielist.MovieListRoute
import com.example.cinemashift.movielist.data.ui.MovieListScreen
import com.example.cinemashift.movielist.domain.usecase.GetMovieListUseCase
import com.example.cinemashift.movielist.presentation.MovieListViewModel
import com.example.cinemashift.navigation.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen()
{
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = Route.ListRoute.route) {
            composable(route = Route.ListRoute.route) {
                MovieListScreen(
                    viewModel = MovieListViewModel(GetMovieListUseCase()),
                    onItemSelected = {navController.navigate(Route.DetailsRoute.route + "/$it")}
                )
            }
            composable(
                route = Route.DetailsRoute.route + "/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.StringType
                })) {
                MovieDetailScreen(
                    movieId = it.arguments!!.getString("id")!!,
                    viewModel = MovieDetailViewModel(GetMovieByIdUseCase())
                )
            }
        }
    }
}