package com.techmashinani.filamu.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.model.response.CastResponse
import com.techmashinani.filamu.model.result.Result
import com.techmashinani.filamu.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val movieRepository: MovieRepository) : BaseViewModel() {

    val simpleMovie: MutableLiveData<Movie> = MutableLiveData()
    val movieLiveData = Transformations.switchMap(simpleMovie) { simpleMovie -> getMovie(simpleMovie.id)}

    fun init(movie: Movie) {
        simpleMovie.postValue(movie)
    }

    private fun getMovie(id: Long): LiveData<CastResponse> {
        val mutable = MutableLiveData<CastResponse>()
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                movieRepository.getMovie(id)
            }

            when(result) {
                is Result.Success -> {
                    mutable.value = result.data
                }
                is Result.Error -> {
                    Timber.e(result.exception)
                }
            }
        }

        return mutable
    }
}