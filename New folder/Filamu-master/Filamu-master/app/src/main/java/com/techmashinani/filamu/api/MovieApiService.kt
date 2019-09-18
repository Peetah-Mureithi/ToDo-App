package com.techmashinani.filamu.api

import com.techmashinani.filamu.model.Movie
import com.techmashinani.filamu.model.Person
import com.techmashinani.filamu.model.response.CastResponse
import com.techmashinani.filamu.model.response.ResultResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiService {

    @GET("/movie/latest")
    fun getLatestMoviesAsync(): Deferred<Movie>

    @GET("movie/upcoming")
    fun getUpcomingMoviesAsync(): Deferred<ResultResponse<Movie>>

    @GET("")
    fun getBestSeries(): Deferred<ResultResponse<Movie>>

    @GET("")
    fun getBestMovies(): Deferred<ResultResponse<Movie>>

    @GET("movie/{movie_id}/casts")
    fun getMovieAsync(
        @Path("movie_id") id: Long
    ): Deferred<CastResponse>

    @GET("person/{person_id}")
    fun getPerson(
        @Path("person_id") id: Long
    ): Deferred<Person>
}