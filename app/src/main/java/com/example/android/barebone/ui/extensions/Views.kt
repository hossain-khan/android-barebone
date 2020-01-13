package com.example.android.barebone.ui.extensions

import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

/**
 * Hides keyboard for specified view.
 */
fun View.hideKeyboard() {
    val imm = ContextCompat.getSystemService(this.context, InputMethodManager::class.java)
    imm?.hideSoftInputFromWindow(this.windowToken, 0)
}

/**
 * Callbacks provided function when keyboard's DONE is pressed on EditText
 */
fun TextInputEditText.onKeyboardActionDone(callbackFunction: () -> Unit) {
    this.apply {
        setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE ->
                    callbackFunction.invoke()
            }
            // Return true if you have consumed the action, else false.
            false
        }
    }
}

/**
 * Callbacks provided function when keyboard's DELETE is pressed on EditText
 */
fun TextInputEditText.onKeyboardDeleteKey(callbackFunction: () -> Unit) {
    this.apply {
        setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                callbackFunction.invoke()
            }
            false
        }
    }
}
