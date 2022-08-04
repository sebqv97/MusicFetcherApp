package com.sebqv97.scratchapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sebqv97.scratchapplication.model.MusicModel
import com.sebqv97.scratchapplication.repository.Repository
import com.sebqv97.scratchapplication.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var repository: Repository) : ViewModel() {

    private val _musicDetails: MutableLiveData<UiState> = MutableLiveData(UiState.Loading)
    val musicDetails: LiveData<UiState> get() = _musicDetails


    fun getSongs(songType: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = repository.getMusic(songType)
            if (response.isSuccessful) {
                //value vs postValue : value overwrites it immediately, not making a broadcast,
                // while the other one signals a broadcast to the observer
                _musicDetails.postValue(
                    response.body()?.let { success ->
                        UiState.Success(
                            MusicModel(
                                success.resultCount,
                                success.results
                            )
                        )
                    })

            } else {

                //if you don't implement UIState
               // throw Exception(response.errorBody()?.string())

                //if you implement UiSTATE(we do)
                _musicDetails.postValue(
                    UiState.Failure(Throwable((response.message())))
                )

            }
        } catch (e: Exception) {
            Log.e("error", e.toString())
        }
    }

}