package com.example.demoapplicaion.presentation.di

import com.example.demoapplicaion.data.repository.SearchRepositoryImpl
import com.example.demoapplicaion.data.repository.datasource.SearchDataSource
import com.example.demoapplicaion.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        searchDataSource: SearchDataSource

    ): SearchRepository {
        return SearchRepositoryImpl(
            searchDataSource
        )
    }
}