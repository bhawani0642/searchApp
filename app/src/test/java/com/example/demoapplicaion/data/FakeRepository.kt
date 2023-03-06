package com.example.demoapplicaion.data

import com.example.demoapplicaion.data.model.Lf
import com.example.demoapplicaion.data.model.SearchResult
import com.example.demoapplicaion.data.model.SearchResultItem
import com.example.demoapplicaion.data.model.Var
import com.example.demoapplicaion.domain.repository.SearchRepository


class FakeRepository : SearchRepository {
    private val searchList = mutableListOf<Lf>()

    init {
            val varsList: ArrayList<Var>? =ArrayList<Var>()
            var vars= Var(50,"Measurement of the Environment",1977)
            varsList?.add(vars)
            var lf= Lf(50,"Measurement of the Environment",1977,varsList)
            searchList.add(lf)


    }
    override suspend fun getNewsHeadlines(country: String): List<Lf> {
       return searchList
    }


}