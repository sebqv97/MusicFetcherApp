package com.sebqv97.scratchapplication.di

import com.google.gson.Gson
import com.sebqv97.scratchapplication.data.ApiDetails
import com.sebqv97.scratchapplication.data.ApiReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideGson():Gson = Gson()

    @Provides
    fun httploggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    fun retrofitSetup(gson:Gson, okHttpClient: OkHttpClient):Retrofit = Retrofit.Builder()
        .baseUrl(ApiReference.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    fun getApiDetails(retrofit: Retrofit): ApiDetails {
        return retrofit.create(ApiDetails::class.java)
    }
}