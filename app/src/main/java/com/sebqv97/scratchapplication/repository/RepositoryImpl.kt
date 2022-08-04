package com.sebqv97.scratchapplication.repository

import com.sebqv97.scratchapplication.data.ApiDetails
import com.sebqv97.scratchapplication.model.MusicModel
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiDetails: ApiDetails) : Repository {
    override suspend fun getMusic(musicType:String): Response<MusicModel> =

        apiDetails.getSongs(musicType,"music","musicVideo",50)



}