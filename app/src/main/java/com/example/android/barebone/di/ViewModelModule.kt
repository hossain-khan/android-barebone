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
    abstract fun bindLoginViewModel(featureZViewModel: FeatureZViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}
