package com.sebqv97.scratchapplication.data

import com.sebqv97.scratchapplication.MusicApp
import com.sebqv97.scratchapplication.model.MusicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDetails {
    @GET("/search")
    suspend fun getSongs(
        @Query("term") musicType:String,
        @Query("media") mediaType:String,
        @Query("entity") entityType:String,
        @Query("limit") limit:Int

    ) :Response<MusicModel> //bundles, individual, properties
//    @GET("https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50")
//    suspend fun getRock() :Response<MusicModel> //bundles, individual, properties
//    @GET("https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
//    suspend fun getClassic() :Response<MusicModel> //bundles, individual, properties

}