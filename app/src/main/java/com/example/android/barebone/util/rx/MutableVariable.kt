package com.example.android.barebone.util.rx

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject

/**
 * Port of Variable from RX Swift to Kotlin.
 * Variable is a wrapper for BehaviorSubject.
 *
 * Unlike `BehaviorSubject` it can't terminate with error, and when variable is deallocated it will
 * complete its observable sequence (`updateListener`).
 *
 * This is essentially an  Rx version of [android.databinding.ObservableField].
 *
 * Note: Variables are like [BehaviorRelays](https://github.com/JakeWharton/RxRelay) except for:
 *       - [Variable.get] is always non-null (MutableVariables are required to have an initial value), where as
 *         BehaviorRelays do not have a value until one is provided.
 *       - Variable (immutable) and MutableVariable are separated out.
 *       - Variable.updateListener() will always emit a value immediately because get() is non-null.
 *
 * @param scheduler is used as the thread to observe [updateListener] on.
 *
 * @see <a href="https://gist.github.com/operando/2add7bbad535bc30f7340bf8c04660d7">Kotlin Implementation</a>
 * @see <a href="https://github.com/ReactiveX/RxSwift/blob/master/RxSwift/Subjects/Variable.swift">Swift Implementation</a>
 */
open class MutableVariable<T : Any> constructor(
    @Volatile
    private var value: T,
    scheduler: Scheduler = Schedulers.computation()
) : Variable<T> {

    private val serializedSubject: Subject<T> = BehaviorSubject.createDefault<T>(value).toSerialized()

    private val updateListener = serializedSubject.observeOn(scheduler)

    override fun get(): T {
        return value
    }

    /**
     * Changes the value stored in this Variable and emits the new value to subscribers.
     */
    @Synchronized
    open fun set(value: T) {
        this.value = value
        serializedSubject.onNext(this.value)
    }

    /**
     * Allows modifying the value in a synchronized way so that the get() and set() are atomic.
     *
     * Note: anything synchronized cannot be `inline`.
     */
    @Synchronized
    fun safeSet(calculateNewValue: (T) -> T) {
        set(calculateNewValue(get()))
    }

    /**
     * Change listener.
     *
     * Observed on computation scheduler.
     *
     * @param transformer Used for shorter syntax when using [Transformers]. This parameter has been deprecated in favor
     *   of Rx extension functions like in [RxExtensions].
     */
    override fun stream(): Observable<T> {
        return updateListener
    }

    /**
     * @return String suitable for debugging.
     */
    override fun toString(): String {
        return value.toString()
    }
}

inline fun <T : Any> MutableVariable<Optional<T>>.setOptional(value: T?) {
    this.set(Optional(value))
}

inline fun <T : Any> MutableVariable<Optional<T>>.getOptional(): T? {
    return this.get().valueOrNull
}
