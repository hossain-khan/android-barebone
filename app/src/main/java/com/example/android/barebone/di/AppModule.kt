package com.example.android.barebone.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    @Provides
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }
}
