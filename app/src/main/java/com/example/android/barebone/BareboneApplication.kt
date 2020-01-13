package com.example.android.barebone

import android.app.Activity
import android.app.Application
import com.example.android.barebone.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import timber.log.Timber
import timber.log.Timber.DebugTree

class BareboneApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        installLogging()

        initDependencyInjection()
    }

    private fun installLogging() {
        if (BuildConfig.DEBUG) {
            // TODO - Check if you need non-debug tree line following:
            // https://github.com/JakeWharton/timber/blob/master/timber-sample/src/main/java/com/example/timber/ExampleApp.java
            Timber.plant(DebugTree())
        }
    }

    private fun initDependencyInjection() {
        // Initialize dagger.
        AppInjector.init(this)
    }
}
