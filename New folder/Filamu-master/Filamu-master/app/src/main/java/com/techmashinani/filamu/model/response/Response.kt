package com.techmashinani.filamu.model.response

data class ResultResponse<out T: Any>(val results: List<T>)