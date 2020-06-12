package com.example.android.barebone.ui.home

import android.content.SharedPreferences
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(private val preferences: SharedPreferences) : ViewModel() {
    init {
        Timber.d("Got injected preference: $preferences")
    }
}
