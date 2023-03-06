package com.example.demoapplicaion.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.demoapplicaion.R
import com.example.demoapplicaion.data.model.Lf
import com.example.demoapplicaion.data.model.SearchResult
import com.example.demoapplicaion.domain.repository.usecase.GetSearchedResultUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel(
    private val app: Application,
    private val getSearchedUseCase: GetSearchedResultUseCase
) : AndroidViewModel(app) {


    fun searchLf(
        country: String,

    ) = liveData {
        if (isNetworkAvailable(app)) {
            val response = getSearchedUseCase.execute(country)
            emit(response)
    }else{
            Toast.makeText(app, "Please check your internet connection", Toast.LENGTH_SHORT).show()
        }

    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

}