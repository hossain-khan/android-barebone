package com.example.android.barebone.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }
}
