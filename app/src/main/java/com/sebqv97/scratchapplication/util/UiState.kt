package com.sebqv97.scratchapplication.util

import com.sebqv97.scratchapplication.model.MusicModel


//the purpose of it is to crate states of the api, as to describe the status of Api fetch
sealed class UiState{
    object Loading : UiState()
    data class Success(val musicResponse: MusicModel) : UiState()
    data class Failure(val error: Throwable) : UiState()
}
