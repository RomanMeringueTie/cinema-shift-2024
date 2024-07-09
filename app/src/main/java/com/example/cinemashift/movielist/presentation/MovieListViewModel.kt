package com.example.cinemashift.movielist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemashift.movielist.domain.usecase.GetMovieListUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieListViewModel(private val getMovieListUseCase: GetMovieListUseCase): ViewModel()
{
    private val _state =MutableStateFlow<MovieListState>(MovieListState.Initial)
    val state: StateFlow<MovieListState> = _state

    fun loadMovieList()
    {
        if (_state.value is MovieListState.Content || _state.value is MovieListState.Loading)
            return
        viewModelScope.launch{
            _state.value = MovieListState.Loading
            try {
                val movieList = getMovieListUseCase()
                _state.value = MovieListState.Content(movieList)
            }
            catch(ce: CancellationException) {
                throw ce
            }
            catch(ex: Exception) {
                _state.value = MovieListState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}