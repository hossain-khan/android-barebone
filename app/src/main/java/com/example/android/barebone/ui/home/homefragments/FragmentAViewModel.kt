package com.example.android.barebone.ui.home.homefragments

import android.content.SharedPreferences
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.barebone.ui.extensions.LiveEvent
import timber.log.Timber

class FragmentAViewModel @ViewModelInject constructor(
    sharedPreferences: SharedPreferences
) : ViewModel() {
    private val _featureXEvent = LiveEvent<Unit>()
    private val _featureYEvent = LiveEvent<Unit>()
    private val _featureZEvent = LiveEvent<Unit>()
    val featureXEvent: LiveData<Unit> = _featureXEvent
    val featureYEvent: LiveData<Unit> = _featureYEvent
    val featureZEvent: LiveData<Unit> = _featureZEvent

    init {
        Timber.i("Got injected shared preferences: %s", sharedPreferences)
    }

    fun openFeatureXClicked() {
        _featureXEvent.value = Unit
    }

    fun openFeatureYClicked() {
        _featureYEvent.value = Unit
    }

    fun openFeatureZClicked() {
        _featureZEvent.value = Unit
    }
}
