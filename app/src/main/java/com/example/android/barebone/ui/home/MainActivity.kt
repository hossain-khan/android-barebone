package com.example.android.barebone.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPagerAdapter: HomePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("Activity created.") // Test logging using timber.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        // Initialize components/views.
        mainPagerAdapter = HomePagerAdapter(this)

        // Show the default screen.
        selectScreen(Screen.HOME)

        // Set the listener for item selection in the bottom navigation view.
        binding.navView.setOnNavigationItemSelectedListener(this)

        // Attach an adapter to the view pager and make it select the bottom navigation
        // menu item and change the title to proper values when selected.
        binding.viewPager.adapter = mainPagerAdapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val selectedScreen: Screen = Screen.values()[position]
                selectBottomNavigationViewMenuItem(selectedScreen.menuItemId)
                supportActionBar?.setTitle(selectedScreen.titleStringId)
            }
        })
    }

    private fun selectScreen(defaultScreen: Screen) {
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        supportActionBar?.setTitle(defaultScreen.titleStringId)
    }

    /**
     * Scrolls ViewPager to show the provided screen.
     */
    private fun scrollToScreen(screen: Screen) {
        if (screen.ordinal != binding.viewPager.currentItem) {
            binding.viewPager.setCurrentItem(screen.ordinal, true)
        }
    }

    /**
     * Selects the specified item in the bottom navigation view.
     */
    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        binding.navView.setOnNavigationItemSelectedListener(null)
        binding.navView.selectedItemId = menuItemId
        binding.navView.setOnNavigationItemSelectedListener(this)
    }

    /**
     * Listener implementation for registering bottom navigation clicks.
     */
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        getMainScreenForMenuItem(menuItem.itemId)?.let { screenItem ->
            scrollToScreen(screenItem)
            supportActionBar?.setTitle(screenItem.titleStringId)
            return true
        }
        return false
    }
}
