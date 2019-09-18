package com.techmashinani.filamu.model.response

import com.techmashinani.filamu.model.Actor
import com.techmashinani.filamu.model.Crew

data class CastResponse(val id: Long, val cast: List<Actor>, val crew: List<Crew>)