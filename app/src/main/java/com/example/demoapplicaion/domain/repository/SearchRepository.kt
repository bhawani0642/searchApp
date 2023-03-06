package com.example.demoapplicaion.domain.repository

import com.example.demoapplicaion.data.model.Lf


interface SearchRepository {
    suspend fun getNewsHeadlines(country : String): List<Lf>
}