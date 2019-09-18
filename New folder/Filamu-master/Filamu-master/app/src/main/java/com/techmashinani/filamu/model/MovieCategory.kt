package com.techmashinani.filamu.model

import androidx.lifecycle.LiveData

data class MovieCategory(val category: String, val movies: LiveData<List<Movie>>)