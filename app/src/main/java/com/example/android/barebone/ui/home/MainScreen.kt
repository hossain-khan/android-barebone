package com.example.android.barebone.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

import com.example.android.barebone.ui.home.homefragments.FragmentA
import com.example.android.barebone.ui.home.homefragments.FragmentB
import com.example.android.barebone.ui.home.homefragments.FragmentC

/**
 * Screens available for display in the main screen, with their respective titles,
 * icons, and menu item IDs and fragments.
 */
enum class MainScreen(
    @IdRes val menuItemId: Int,
    @DrawableRes val menuItemIconId: Int,
    @StringRes val titleStringId: Int,
    val fragment: Fragment
) {
    HOME(
        com.example.android.barebone.R.id.navigation_home,
        com.example.android.barebone.R.drawable.ic_home_black_24dp,
        com.example.android.barebone.R.string.title_home,
        FragmentA()
    ),
    DASHBOARD(
        com.example.android.barebone.R.id.navigation_dashboard,
        com.example.android.barebone.R.drawable.ic_dashboard_black_24dp,
        com.example.android.barebone.R.string.title_dashboard,
        FragmentB()
    ),
    NOTIFICATION(
        com.example.android.barebone.R.id.navigation_notifications,
        com.example.android.barebone.R.drawable.ic_notifications_black_24dp,
        com.example.android.barebone.R.string.title_notifications,
        FragmentC()
    )
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}
