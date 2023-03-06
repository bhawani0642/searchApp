package com.example.demoapplicaion.presentation

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapplicaion.R
import com.example.demoapplicaion.data.model.Lf
import com.example.demoapplicaion.databinding.ActivityMainBinding
import com.example.demoapplicaion.presentation.adapter.SearchAdapter
import com.example.demoapplicaion.presentation.viewmodel.SearchViewModel
import com.example.demoapplicaion.presentation.viewmodel.SearchViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: SearchViewModelFactory
    lateinit var viewModel: SearchViewModel

    @Inject
    lateinit var newsAdapter: SearchAdapter
    private lateinit var mainActivityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
        viewModel = ViewModelProvider(this, factory).get(SearchViewModel::class.java)
        setSearchView()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mainActivityBinding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    private fun setSearchView() {
        mainActivityBinding.svLf .setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if (p0!!.length > 3) {
                        mainActivityBinding.loading=true
                        val responseLiveData=  viewModel.searchLf(p0.toString())
                        viewSearchedNews(responseLiveData)
                    }else{
                        clearList()
                    }
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    MainScope().launch {
                        if (p0!!.length > 3) {
                            mainActivityBinding.loading=true
                            val responseLiveData= viewModel.searchLf(p0.toString())
                            viewSearchedNews(responseLiveData)
                        }else{
                            clearList()
                        }
                    }
                    return false
                }
            })
        mainActivityBinding.svLf.setOnCloseListener(
            object : SearchView.OnCloseListener {
                override fun onClose(): Boolean {
                    initRecyclerView()
                    clearList()
                    return false
                }

            })
    }

    private fun clearList() {
        newsAdapter.differ.submitList(null)
    }

    fun viewSearchedNews(  responseLiveData:LiveData<List<Lf>>) {
        responseLiveData.observe(this, { response ->
            if(response.size>0){
                mainActivityBinding.loading=false
                newsAdapter.differ.submitList(response)
            }else{
                mainActivityBinding.loading=false
                Toast.makeText(this, getString(R.string.no_data_found),Toast.LENGTH_SHORT).show()
            }
        })
    }



}