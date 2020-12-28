package com.example.android.barebone.util.rx

import io.reactivex.rxjava3.core.Observable

/**
 * Immutable interface of [MutableVariable] for the code where you want to expose a [Variable] but
 * do not want the users to modify it.
 *
 * This is essentially an immutable and Rx version of [android.databinding.ObservableField].
 *
 * Note: Variables are like [BehaviorRelays](https://github.com/JakeWharton/RxRelay) except for:
 *       - [Variable.get] is always non-null (MutableVariables are required to have an initial value), where as
 *         BehaviorRelays do not have a value until one is provided.
 *       - Variable (immutable) and MutableVariable are separated out.
 *       - Variable.updateListener() will always emit a value immediately because get() is non-null.
 */
interface Variable<T : Any> {

    /**
     * Gets the current value of this variable.
     */
    fun get(): T

    /**
     * Change listener.
     */
    fun stream(): Observable<T>
}
