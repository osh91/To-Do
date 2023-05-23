package com.example.to_do.util

// * För att det flickar när det laddar upp från database så måste vi ha flagga för att se hur den reagerar synken
sealed class RequestState<out T> {
    object Idle : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val error: Throwable) : RequestState<Nothing>()
}