package com.example.android.barebone

import android.app.Application
import timber.log.Timber.DebugTree
import timber.log.Timber


class BareboneApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        installLogging()
    }

    private fun installLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
        // TODO - Check if you need non-debug tree line following:
        // https://github.com/JakeWharton/timber/blob/master/timber-sample/src/main/java/com/example/timber/ExampleApp.java
    }
}