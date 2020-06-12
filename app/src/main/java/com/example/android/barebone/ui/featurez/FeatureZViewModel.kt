package com.example.android.barebone.ui.featurez

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.barebone.data.DaoService
import com.example.android.barebone.ui.extensions.LiveEvent
import timber.log.Timber

class FeatureZViewModel @ViewModelInject constructor(private val daoService: DaoService) : ViewModel() {
    private val _showDialogEvent = LiveEvent<Unit>()
    val showDialogEvent: LiveData<Unit> = _showDialogEvent

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        // Example code on how the injected service class is used to update data.
        _message.value = daoService.getUserMessage()
    }

    fun showDialogClicked() {
        Timber.i("Show dialog requested.")
        _showDialogEvent.value = Unit
    }
}
