package com.example.android.barebone.util.android

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Monitors the application foreground/background status.
 *
 * Sample usage:
 * ```
 * appLifecycleManager.backgroundState
 *        .subscribe({ isBackgrounded ->
 *            if (isBackgrounded) {
 *                // pause any background activity if applicable
 *            } else {
 *                // app foregrounded reload user data or something
 *            }
 *        }, Timber::e)
 *        .disposeWith(onShutdown)
 * ```
 */
@Singleton
class AppLifecycleManager @Inject constructor(application: Application) {
    companion object {
        /**
         * How long to wait after the last activity is stopped or the first activity is started to actually emit a
         * backgrounded/foregrounded event.
         *
         * Prevents the observable from firing when the screen is rotated.
         */
        private const val DEBOUNCE_TIME_SECONDS = 1L
    }

    @VisibleForTesting
    internal val callbacks: Application.ActivityLifecycleCallbacks = Callbacks()

    private var activeActivityCount = 0

    private val backgroundStateSubject = PublishSubject.create<Boolean>()

    /**
     * Emits _true_ when app is backgrounded. Emits _false_ when app is foregrounded. Has a delay of 1 seconds to ensure
     * it won't fire if the screen is rotated.
     */
    val backgroundState: Observable<Boolean> by lazy {
        backgroundStateSubject
                .debounce(DEBOUNCE_TIME_SECONDS, TimeUnit.SECONDS)
    }

    init {
        application.registerActivityLifecycleCallbacks(callbacks)
    }

    private inner class Callbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityResumed(activity: Activity) {
        }

        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStarted(activity: Activity) {
            synchronized(activeActivityCount) {
                activeActivityCount++
                if (activeActivityCount == 1) {
                    backgroundStateSubject.onNext(false)
                }
            }
        }

        override fun onActivityStopped(activity: Activity) {
            synchronized(activeActivityCount) {
                activeActivityCount--
                if (activeActivityCount == 0) {
                    backgroundStateSubject.onNext(true)
                }
            }
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        }

        override fun onActivityDestroyed(activity: Activity) {
        }
    }
}
