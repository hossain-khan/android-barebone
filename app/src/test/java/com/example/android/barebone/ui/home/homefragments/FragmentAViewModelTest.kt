package com.example.android.barebone.ui.home.homefragments

import android.content.SharedPreferences
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.android.barebone.test.MockLifecycleOwner
import com.example.android.barebone.test.mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class FragmentAViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule() // Required to test LiveData

    private lateinit var sut: FragmentAViewModel
    private lateinit var preferences: SharedPreferences

    private val eventObserver: Observer<Unit> = mock()
    private val lifecycleOwner = MockLifecycleOwner()

    @Before
    fun setUp() {
        preferences = mock(SharedPreferences::class.java)

        sut = FragmentAViewModel(preferences)
    }

    @Test
    fun openFeatureXClicked() {

        sut.featureXEvent.observe(lifecycleOwner, eventObserver)

        sut.openFeatureXClicked()

        lifecycleOwner.start()

        verify(eventObserver, times(1)).onChanged(Unit)
    }
}
