package com.example.android.barebone.di

import android.app.Application
import com.example.android.barebone.BareboneApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DataStoreModule::class,
        NetworkModule::class,
        ActivityBindingModule::class,
        ActivityFeatureZModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BareboneApplication)
}
