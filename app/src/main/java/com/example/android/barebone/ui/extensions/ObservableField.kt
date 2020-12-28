package com.example.android.barebone.ui.extensions

import androidx.databinding.Observable
import androidx.databinding.ObservableField

/**
 * Observable field extension that allows you to observe without much boilerplate code.
 *
 * Usage:
 * ```
 *  viewModel.field.onChanged { result ->
 *     // Do something with `result` data
 *  }
 * ```
 */
inline fun <T> ObservableField<T>.onChanged(crossinline callback: (T) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            callback.invoke(get()!!)
        }
    })
}

/**
 * Converts an [ObservableField] to Rx stream in safe way by automatically removing callback on unsubscription.
 * This avoids memory leak from activity.
 */
fun <T> ObservableField<T>.toObservable(): io.reactivex.rxjava3.core.Observable<T> {
    return io.reactivex.rxjava3.core.Observable.create { e ->
        val initialValue = get()
        if (initialValue != null) {
            e.onNext(initialValue)
        }
        val callback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                e.onNext(get()!!)
            }
        }
        addOnPropertyChangedCallback(callback)
        e.setCancellable { removeOnPropertyChangedCallback(callback) }
    }
}
