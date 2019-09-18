package com.techmashinani.filamu.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.techmashinani.filamu.model.result.Result
import com.techmashinani.filamu.model.Actor
import com.techmashinani.filamu.model.Person
import com.techmashinani.filamu.repository.CastRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class ActorViewModel @Inject constructor(private val actorRepository: CastRepository) : BaseViewModel() {

    val actorLiveData: MutableLiveData<Actor> = MutableLiveData()
    val personLiveData: LiveData<Person> = Transformations.switchMap(actorLiveData) {
        return@switchMap getPerson(it.id)
    }

    fun init(actor: Actor) {
        actorLiveData.postValue(actor)
    }

    private fun getPerson(id: Long): LiveData<Person> {
        val liveData = MutableLiveData<Person>()

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                actorRepository.getCrewMember(id)
            }

            when(result) {
                is Result.Success -> {
                    liveData.value = result.data
                }
                is Result.Error -> {
                    liveData.value = null
                    Timber.e(result.exception)
                }
            }
        }

        return liveData
    }
}