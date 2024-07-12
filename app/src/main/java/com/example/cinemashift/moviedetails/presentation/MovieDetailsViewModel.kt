package com.example.cinemashift.moviedetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemashift.moviedetails.domain.usecase.GetMovieByIdUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val getMovieByIdUseCase: GetMovieByIdUseCase): ViewModel() {
    private val _state = MutableStateFlow<MovieItemState>(MovieItemState.Initial)
    val state: StateFlow<MovieItemState> = _state

    fun loadById(id: String) {
        if (_state.value is MovieItemState.Content || _state.value is MovieItemState.Loading)
            return
        viewModelScope.launch{
            try {
                val movie = getMovieByIdUseCase(id)
                _state.value = MovieItemState.Content(movie)
            }
            catch(ce: CancellationException) {
                throw ce
            }
            catch(ex: Exception) {
                _state.value = MovieItemState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}