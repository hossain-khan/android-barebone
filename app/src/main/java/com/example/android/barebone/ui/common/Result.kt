package com.example.android.barebone.ui.common

import androidx.lifecycle.LiveData
import com.example.android.barebone.ui.extensions.LiveEvent

/**
 * A generic class that holds a value with its loading status.
 *
 * From view model, provide appropriate result via [LiveEvent]/[LiveData].
 * ```
 * private val _loginResult = LiveEvent<Result<User>>()
 * val loginResult: LiveData<Result<Unit>> = _loginResult
 *
 * userApi
 *    .usersLoginPost(UserAuthBody(email, password))
 *    .subscribe({ user ->
 *        _loginResult.value = Result.Success(user)
 *    }, { error ->
 *        _loginResult.value = Result.Error(error)
 *    })
 * ```
 *
 * In activity, observe [LiveEvent]/[LiveData] for result.
 *
 * ```
 * when (result) {
 *     is Result.Success -> {
 *         // Navigate somewhere
 *         startActivity(Intent(this, MainActivity::class.java))
 *         // Or you can receive data and populate UI
 *         adapter.setData(result.data)
 *     }
 *     is Result.Error -> {
 *         // Show error dialog/snackbar or message
 *         Toast.makeText(this, result.exception.message, Toast.LENGTH_LONG).show()
 *     }
 * }
 * ```
 *
 * @param <T> Type of data on success.
 */
sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
