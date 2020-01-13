package com.example.android.barebone.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import timber.log.Timber

class HomeViewModel @Inject constructor(private val preferences: SharedPreferences) : ViewModel() {
    init {
        Timber.d("Got injected preference: $preferences")
    }
}
