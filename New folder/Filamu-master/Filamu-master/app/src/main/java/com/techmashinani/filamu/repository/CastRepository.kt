package com.techmashinani.filamu.repository

import com.techmashinani.filamu.api.MovieApiService
import com.techmashinani.filamu.model.Person
import com.techmashinani.filamu.model.result.Result
import javax.inject.Inject

class CastRepository @Inject constructor(private val apiService: MovieApiService) {

    suspend fun getCrewMember(id: Long): Result<Person> {
        try {
            val person = apiService.getPerson(id).await()
            return Result.Success(person)
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}