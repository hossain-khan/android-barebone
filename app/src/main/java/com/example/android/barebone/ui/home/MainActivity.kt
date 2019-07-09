package com.example.android.barebone.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidFragmentInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        Timber.d("Activity created.") // Test logging using timber.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        // Initialize components/views.
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)

        // Show the default screen.
        selectScreen(MainScreen.HOME)

        // Set the listener for item selection in the bottom navigation view.
        binding.navView.setOnNavigationItemSelectedListener(this)

        // Attach an adapter to the view pager and make it select the bottom navigation
        // menu item and change the title to proper values when selected.
        binding.viewPager.adapter = mainPagerAdapter
        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val selectedScreen = mainPagerAdapter.getItems()[position]
                selectBottomNavigationViewMenuItem(selectedScreen.menuItemId)
                supportActionBar?.setTitle(selectedScreen.titleStringId)
            }
        })
    }

    private fun selectScreen(defaultScreen: MainScreen) {
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        supportActionBar?.setTitle(defaultScreen.titleStringId)
    }

    /**
     * Scrolls ViewPager to show the provided screen.
     */
    private fun scrollToScreen(mainScreen: MainScreen) {
        val screenPosition = mainPagerAdapter.getItems().indexOf(mainScreen)
        if (screenPosition != binding.viewPager.currentItem) {
            binding.viewPager.currentItem = screenPosition
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
