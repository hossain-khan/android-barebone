package com.example.android.barebone.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.barebone.ui.extensions.LiveEvent
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val preferences: SharedPreferences) : ViewModel() {

    private val _featureXEvent = LiveEvent<Unit>()
    private val _featureYEvent = LiveEvent<Unit>()
    private val _featureZEvent = LiveEvent<Unit>()
    val featureXEvent: LiveData<Unit> = _featureXEvent
    val featureYEvent: LiveData<Unit> = _featureYEvent
    val featureZEvent: LiveData<Unit> = _featureZEvent

    init {
        Timber.d("Got injected preference: $preferences")
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