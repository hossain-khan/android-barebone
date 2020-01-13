package com.example.android.barebone.data

import javax.inject.Inject

/**
 * This is a sample service class which could be used to access database.
 * TODO: Replace/delete accordingly.
 */
class DaoService @Inject constructor() {
    fun getUserMessage(): String {
        return "This is a message from Data Access Object service which is injected via Dagger."
    }
}
