package com.example.android.barebone.di

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class DataStoreModule {
    @Provides
    internal fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    }

    @Provides
    internal fun provideAndroidResoures(context: Context): Resources {
        return context.resources
    }
}
