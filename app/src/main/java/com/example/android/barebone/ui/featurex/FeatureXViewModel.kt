package com.example.android.barebone.ui.featurex

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.android.barebone.api.WebServiceApi
import com.example.android.barebone.ui.common.Result
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class FeatureXViewModel @ViewModelInject constructor(private val api: WebServiceApi) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isOperationInProgress = ObservableField(false)
    val message = ObservableField<Result<String>>()

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
                    message.set(Result.Success(it.messsage ?: ""))
                }, { error ->
                    Timber.e(error)
                    message.set(Result.Error(error))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
