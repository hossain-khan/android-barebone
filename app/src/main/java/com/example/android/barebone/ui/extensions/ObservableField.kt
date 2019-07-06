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