package com.example.android.barebone.di

import com.example.android.barebone.ui.home.homefragments.FragmentA
import com.example.android.barebone.ui.home.homefragments.FragmentB
import com.example.android.barebone.ui.home.homefragments.FragmentC
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module for injecting fragment.
 */
@Suppress("unused")
@Module
abstract class ActivityMainFragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun contributeFragmentA(): FragmentA

    @ContributesAndroidInjector
    abstract fun contributeFragmentB(): FragmentB

    @ContributesAndroidInjector
    abstract fun contributeFragmentC(): FragmentC
}
