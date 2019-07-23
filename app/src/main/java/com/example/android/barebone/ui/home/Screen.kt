package com.example.android.barebone.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes

/**
 * Screens available for display in the main screen, with their respective titles,
 * icons, and menu item IDs and fragments.
 */
enum class Screen(
    @IdRes val menuItemId: Int,
    @DrawableRes val menuItemIconId: Int,
    @StringRes val titleStringId: Int
) {
    HOME(
        com.example.android.barebone.R.id.navigation_home,
        com.example.android.barebone.R.drawable.ic_home_black_24dp,
        com.example.android.barebone.R.string.title_home
    ),
    DASHBOARD(
        com.example.android.barebone.R.id.navigation_dashboard,
        com.example.android.barebone.R.drawable.ic_dashboard_black_24dp,
        com.example.android.barebone.R.string.title_dashboard
    ),
    NOTIFICATION(
        com.example.android.barebone.R.id.navigation_notifications,
        com.example.android.barebone.R.drawable.ic_notifications_black_24dp,
        com.example.android.barebone.R.string.title_notifications
    )
}

fun getMainScreenForMenuItem(menuItemId: Int): Screen? {
    for (mainScreen in Screen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}
