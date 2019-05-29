package com.example.android.barebone.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.barebone.ui.featurex.FeatureXViewModel
import com.example.android.barebone.ui.featurez.FeatureZViewModel
import com.example.android.barebone.ui.home.HomeViewModel
import com.example.android.barebone.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Uses dagger multi-binding to provide [ViewModel] instances used in the app.
 *
 * @see <a href="https://dagger.dev/multibindings">Multibindings</a>
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FeatureXViewModel::class)
    abstract fun bindFeatureXViewModel(featureXViewModel: FeatureXViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FeatureZViewModel::class)
    abstract fun bindFeatureZViewModel(featureZViewModel: FeatureZViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}
