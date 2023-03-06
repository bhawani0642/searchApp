package com.example.demoapplicaion.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapplicaion.domain.repository.usecase.GetSearchedResultUseCase

class SearchViewModelFactory(private val app: Application,
                             private val getNewsHeadlinesUseCase: GetSearchedResultUseCase):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(
            app,
            getNewsHeadlinesUseCase,

        ) as T
    }
}