package com.example.android.barebone.di

import com.example.android.barebone.ui.featurez.FeatureZDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module for injecting fragment.
 */
@Suppress("unused")
@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun contributeFeatureZFragment(): FeatureZDialogFragment
}
