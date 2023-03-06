package com.example.demoapplicaion.data.api

import com.example.demoapplicaion.data.model.SearchResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPIService {

  @GET("software/acromine/dictionary.py")
  suspend fun getSearchedItem(
      @Query("sf")
      sf:String
  ): Response<SearchResult>


}