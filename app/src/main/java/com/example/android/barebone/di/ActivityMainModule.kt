package com.example.android.barebone.di

import com.example.android.barebone.ui.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

/**
 * This is activity specific module since the activity hosts a fragment which also needs to be injected.
 * This is done via [HasSupportFragmentInjector] for the host activity.
 *
 * @see <a href="https://dagger.dev/android">Dagger Android</a>
 * @see AppComponent to add this module in the module list.
 */
@Suppress("unused")
@Module
abstract class ActivityMainModule {
    @ContributesAndroidInjector(
        modules = [
            ActivityMainFragmentBindingModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}
