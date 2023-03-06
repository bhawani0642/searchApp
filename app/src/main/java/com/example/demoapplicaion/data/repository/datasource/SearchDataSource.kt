package com.example.demoapplicaion.data.repository.datasource

import com.example.demoapplicaion.data.model.SearchResult
import retrofit2.Response

interface SearchDataSource {
    suspend fun getSearchedItems(country : String): Response<SearchResult>
}