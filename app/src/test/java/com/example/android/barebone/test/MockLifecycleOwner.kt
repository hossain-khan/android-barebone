package com.example.android.barebone.test

import androidx.annotation.NonNull
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * Mock life cycle owner to test LiveData using events.
 *
 * Usage:
 * ```
 * val owner = MockLifecycleOwner()
 *
 * // observe the LiveData first
 * // liveDataEvent.observe(lifecycleOwner, eventObserver)
 *
 * owner.start()
 * ```
 */
class MockLifecycleOwner() : LifecycleOwner {
    private val registry = LifecycleRegistry(this)

    val currentState: Lifecycle.State
        @NonNull
        get() = registry.currentState

    fun create(): MockLifecycleOwner {
        return handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    fun start(): MockLifecycleOwner {
        return handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    fun resume(): MockLifecycleOwner {
        return handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    fun pause(): MockLifecycleOwner {
        return handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    fun stop(): MockLifecycleOwner {
        return handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

    fun destroy(): MockLifecycleOwner {
        return handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    private fun handleLifecycleEvent(@NonNull event: Lifecycle.Event): MockLifecycleOwner {
        registry.handleLifecycleEvent(event)
        return this
    }

    @NonNull
    override fun getLifecycle(): Lifecycle {
        return registry
    }
}
