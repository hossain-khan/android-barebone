package com.example.android.barebone.ui.featurex

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.android.barebone.api.WebServiceApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class FeatureXViewModel @Inject constructor(private val api: WebServiceApi) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isOperationInProgress = ObservableField(false)
    val message = ObservableField("")

    fun onSendWebRequest(name: String) {
        Timber.i("Sending web request with name: $name")

        compositeDisposable.add(
            api.hello(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isOperationInProgress.set(true) }
                .doOnSuccess { isOperationInProgress.set(false) }
                .doOnError { isOperationInProgress.set(false) }
                .subscribe({
                    message.set(it.messsage ?: "")
                }, { error ->
                    Timber.e(error)
                    message.set(error.message ?: "Error")
                })
        )
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}