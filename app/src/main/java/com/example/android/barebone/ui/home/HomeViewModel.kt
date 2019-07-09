package com.example.android.barebone.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val preferences: SharedPreferences) : ViewModel() {
    init {
        Timber.d("Got injected preference: $preferences")
    }
}