package com.techmashinani.filamu.repository

import com.techmashinani.filamu.api.MovieApiService
import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.model.response.CastResponse
import com.techmashinani.filamu.model.result.Result
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: MovieApiService) {

    suspend fun getMovies(): Result<Movie> {
        return try {
            val deferred =  apiService.getLatestMoviesAsync().await()
            Result.Success(deferred)
        } catch(e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return try {
            val upcoming = apiService.getUpcomingMoviesAsync().await()
            return Result.Success(upcoming.results)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }
    }

    suspend  fun getMovie(movieId: Long): Result<CastResponse> {
        return try {
            val movie = apiService.getMovieAsync(movieId).await()
            Result.Success(movie)
        } catch (e: java.lang.Exception) {
            Result.Error(e)
        }
    }
}