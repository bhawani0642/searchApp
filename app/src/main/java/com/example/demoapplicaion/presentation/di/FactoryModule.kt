package com.example.demoapplicaion.presentation.di

import android.app.Application
import com.example.demoapplicaion.domain.repository.usecase.GetSearchedResultUseCase
import com.example.demoapplicaion.presentation.viewmodel.SearchViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getSearchedResultUseCase: GetSearchedResultUseCase

    ): SearchViewModelFactory {
        return SearchViewModelFactory(
            application,
            getSearchedResultUseCase
        )
    }
}