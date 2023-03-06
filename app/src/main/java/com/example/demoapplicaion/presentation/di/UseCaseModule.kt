package com.example.demoapplicaion.presentation.di

import com.example.demoapplicaion.domain.repository.SearchRepository
import com.example.demoapplicaion.domain.repository.usecase.GetSearchedResultUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideSearchUseCase(
        newsRepository: SearchRepository
    ):GetSearchedResultUseCase{
        return GetSearchedResultUseCase(newsRepository)
    }
}