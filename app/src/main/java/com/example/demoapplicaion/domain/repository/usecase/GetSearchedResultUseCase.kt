package com.example.demoapplicaion.domain.repository.usecase

import com.example.demoapplicaion.data.model.Lf
import com.example.demoapplicaion.data.model.SearchResult
import com.example.demoapplicaion.domain.repository.SearchRepository

class GetSearchedResultUseCase(private val newsRepository: SearchRepository) {
    suspend fun execute(country:String):  List<Lf> {
        return newsRepository.getNewsHeadlines(country)
    }
}