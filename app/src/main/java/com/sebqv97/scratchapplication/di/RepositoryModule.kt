package com.sebqv97.scratchapplication.di

import androidx.lifecycle.ViewModel
import com.sebqv97.scratchapplication.data.ApiDetails
import com.sebqv97.scratchapplication.repository.Repository
import com.sebqv97.scratchapplication.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {



    /// 1
//    @Provides
//    fun getRepositoryAccess(retrofit: Retrofit):Repository = retrofit.create(Repository::class.java)


    ///2

//    @Provides
//    fun getRepoAccess(myApi: ApiDetails):Repository = RepositoryImpl(myApi)

    //////3

    @Binds
    abstract fun getRepoAccess(repository: RepositoryImpl):Repository
}