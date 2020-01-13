package com.example.android.barebone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.barebone.di.ViewModelModule
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * The [ViewModelProvider.Factory] to get instance of all viewmodels using Dagger multi-binding.
 *
 *
 * @see <a href="https://dagger.dev/multibindings">Multibindings</a>
 * @see [ViewModelModule]
 */
@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("Unknown view model class $modelClass. Must be added to map first.")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
