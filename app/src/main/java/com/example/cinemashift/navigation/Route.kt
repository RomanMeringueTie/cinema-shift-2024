package com.example.cinemashift.navigation

sealed class Route(val route: String) {
    object ListRoute: Route("list")
    object DetailsRoute: Route("details")
}