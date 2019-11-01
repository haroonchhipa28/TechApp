package com.example.mohammadchhipa.techchallengeapp.data

sealed class Result {
    object Loading : Result()
    data class Success(val response: Any?) : Result()
    data class Failure(val throwable: Throwable) : Result()
}