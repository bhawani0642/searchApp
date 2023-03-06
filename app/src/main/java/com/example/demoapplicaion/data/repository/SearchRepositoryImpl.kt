package com.example.demoapplicaion.data.repository

import android.util.Log
import com.example.demoapplicaion.data.model.Lf
import com.example.demoapplicaion.data.model.SearchResult
import com.example.demoapplicaion.data.repository.datasource.SearchDataSource
import com.example.demoapplicaion.domain.repository.SearchRepository
import java.lang.Exception

class SearchRepositoryImpl(  private val searchRemoteDataSource: SearchDataSource):SearchRepository {
    override suspend fun getNewsHeadlines(country: String):  List<Lf> {
         var lfs = mutableListOf<Lf>()
        try {
            val response = searchRemoteDataSource.getSearchedItems(country)
            val body = response.body()
            if(body!=null && body.size>0){
                lfs= body.get(0).lfs as MutableList<Lf>
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return lfs
    }


}