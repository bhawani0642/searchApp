package com.example.demoapplicaion.presentation.di

import com.example.demoapplicaion.data.api.SearchAPIService
import com.example.demoapplicaion.data.repository.datasource.SearchDataSource
import com.example.demoapplicaion.data.repository.datasourceImpl.SearchDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SearchDataModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(
        newsAPIService: SearchAPIService
    ): SearchDataSource {
        return SearchDataSourceImpl(newsAPIService)
    }
}