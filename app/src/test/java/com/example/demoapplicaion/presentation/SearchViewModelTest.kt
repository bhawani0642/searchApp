package com.example.demoapplicaion.presentation


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.demoapplicaion.data.FakeRepository
import com.example.demoapplicaion.data.model.Lf
import com.example.demoapplicaion.data.model.SearchResult
import com.example.demoapplicaion.data.model.SearchResultItem
import com.example.demoapplicaion.data.model.Var
import com.example.demoapplicaion.domain.repository.usecase.GetSearchedResultUseCase
import com.example.demoapplicaion.getOrAwaitValue
import com.example.demoapplicaion.presentation.viewmodel.SearchViewModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`


@RunWith(AndroidJUnit4::class)
class SearchViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: SearchViewModel


    @Before
    fun setUp() {
        val fakeSearchRepository = FakeRepository()
        val getMoviesUseCase = GetSearchedResultUseCase(fakeSearchRepository)
        viewModel = SearchViewModel(ApplicationProvider.getApplicationContext(),getMoviesUseCase)
    }

    @Test
    fun getSearchedList_returnsCurrentList(){
        val searchList = mutableListOf<Lf>()
        val varsList: ArrayList<Var>? =ArrayList<Var>()
        var vars= Var(50,"Measurement of the Environment",1977)
        varsList?.add(vars)
        var lf= Lf(50,"Measurement of the Environment",1977,varsList)
        searchList.add(lf)
        val currentList = viewModel.searchLf("home").getOrAwaitValue()
        assertThat(currentList).isEqualTo(searchList)
    }


}