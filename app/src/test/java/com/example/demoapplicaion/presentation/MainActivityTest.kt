package com.example.demoapplicaion.presentation
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import com.example.demoapplicaion.data.FakeRepository
import com.example.demoapplicaion.domain.repository.usecase.GetSearchedResultUseCase
import com.example.demoapplicaion.presentation.adapter.SearchAdapter
import com.example.demoapplicaion.presentation.viewmodel.SearchViewModel
import com.example.demoapplicaion.presentation.viewmodel.SearchViewModelFactory
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject
@HiltAndroidTest
@Config(sdk = intArrayOf(Build.VERSION_CODES.P))
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    val executorRule = InstantTaskExecutorRule()
    private lateinit var mActivity: MainActivity
    @Before
    @Throws(Exception::class)
    fun setUp() {
        mActivity = Robolectric.buildActivity(MainActivity::class.java)
            .get()

    }

    @Test
    @Throws(Exception::class)
    fun ActivityShouldNotBeNull() {
        assertNotNull(mActivity)
    }

    @Test
    @Throws(Exception::class)
    fun ViewModelShouldNotBeNull(){
        val fakeSearchRepository = FakeRepository()
        val getMoviesUseCase = GetSearchedResultUseCase(fakeSearchRepository)
        mActivity.viewModel = SearchViewModel(ApplicationProvider.getApplicationContext(),getMoviesUseCase)
        assertNotNull(mActivity.viewModel)
    }



}