package com.example.android.barebone.di

import com.example.android.barebone.ui.featurez.FeatureZActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityFeatureZModule {
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun contributeFeatureZActivity(): FeatureZActivity
}
