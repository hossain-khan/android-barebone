package com.example.android.barebone.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.barebone.ui.extensions.LiveEvent
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val preferences: SharedPreferences) : ViewModel() {
    init {
        Timber.d("Got injected preference: $preferences")
    }

}