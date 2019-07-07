package com.example.android.barebone.ui.home.homefragments

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class FragmentAViewModel @Inject constructor(
    sharedPreferences: SharedPreferences
) : ViewModel() {
    init {
        Timber.i("Got injected shared preferences: %s", sharedPreferences)
    }
}