package com.example.android.barebone.util.rx

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber

@Suppress("unused") // Only used for debugging.
fun <T : Any> Observable<T>.logEvents(context: String): Observable<T> {
    return this.doOnSubscribe {
        Timber.d("%s started subscription", context)
    }
        .doFinally {
            Timber.d("%s ended with unsubscription", context)
        }
        .doOnEach {
            Timber.d("%s event %s", context, it)
        }
}

@Suppress("unused") // Only used for debugging.
fun <T : Any> Single<T>.logEvents(context: String): Single<T> {
    return this.doOnSubscribe {
        Timber.d("%s started subscription", context)
    }
        .doFinally {
            Timber.d("%s ended with unsubscription", context)
        }
        .doOnEvent { event, throwable ->
            Timber.d(throwable, "%s event %s, throwable %s", context, event, throwable.message)
        }
}

@Suppress("unused") // Only used for debugging.
fun Completable.logEvents(context: String): Completable {
    return this.doOnSubscribe {
        Timber.d("%s started subscription", context)
    }
        .doFinally {
            Timber.d("%s ended with unsubscription", context)
        }
        .doOnEvent { error ->
            if (error == null) {
                Timber.d("%s completed", context)
            } else {
                Timber.d(error, "%s error %s", context, error.message)
            }
        }
}

/**
 * Uses provided disposable to add itself for automatic disposing when stream is unsubscribed.
 */
inline fun Disposable.disposeWith(composite: CompositeDisposable) {
    composite.add(this)
}
