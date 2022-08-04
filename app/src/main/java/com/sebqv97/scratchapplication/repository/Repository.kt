package com.sebqv97.scratchapplication.repository

import com.sebqv97.scratchapplication.model.MusicModel
import retrofit2.Response

interface Repository {
    suspend fun getMusic(musicType:String): Response<MusicModel>


}