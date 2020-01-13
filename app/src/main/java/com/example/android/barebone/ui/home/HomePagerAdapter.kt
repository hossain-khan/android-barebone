package com.example.android.barebone.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.barebone.ui.home.homefragments.FragmentA
import com.example.android.barebone.ui.home.homefragments.FragmentB
import com.example.android.barebone.ui.home.homefragments.FragmentC

class HomePagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    companion object {
        private val TABS = arrayListOf(
            Screen.HOME,
            Screen.DASHBOARD,
            Screen.NOTIFICATION
        )
    }

    override fun getItemCount(): Int {
        return TABS.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (TABS[position]) {
            Screen.HOME -> {
                FragmentA.createInstance()
            }
            Screen.DASHBOARD -> {
                FragmentB.createInstance()
            }
            Screen.NOTIFICATION -> {
                FragmentC.createInstance()
            }
        }
    }
}
