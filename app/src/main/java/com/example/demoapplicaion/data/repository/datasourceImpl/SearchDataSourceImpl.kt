package com.example.demoapplicaion.data.repository.datasourceImpl

import com.example.demoapplicaion.data.api.SearchAPIService
import com.example.demoapplicaion.data.model.SearchResult
import com.example.demoapplicaion.data.repository.datasource.SearchDataSource
import retrofit2.Response

class SearchDataSourceImpl(private val newsAPIService: SearchAPIService): SearchDataSource {
    override suspend fun getSearchedItems(country: String): Response<SearchResult> {
        return newsAPIService.getSearchedItem(country)
    }


}