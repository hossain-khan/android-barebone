package com.example.android.barebone.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityMainBinding
import com.example.android.barebone.ui.featurex.FeatureXActivity
import com.example.android.barebone.ui.featurey.FeatureYActivity
import com.example.android.barebone.ui.featurez.FeatureZActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityMainBinding

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                binding.message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                binding.message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                binding.message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        Timber.d("Activity created.") // Test logging using timber.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        observeNavigationEvents(viewModel)
    }

    /**
     * TODO: This is an example of how LiveData can be used to navigate. Update accordingly.
     */
    private fun observeNavigationEvents(viewModel: HomeViewModel) {
        viewModel.featureXEvent.observe(this, Observer {
            Timber.i("Launching feature X activity.")
            startActivity(Intent(this@MainActivity, FeatureXActivity::class.java))
        })

        viewModel.featureYEvent.observe(this, Observer {
            Timber.i("Launching feature Y activity.")
            startActivity(Intent(this@MainActivity, FeatureYActivity::class.java))
        })

        viewModel.featureZEvent.observe(this, Observer {
            Timber.i("Launching feature Z activity.")
            startActivity(Intent(this@MainActivity, FeatureZActivity::class.java))
        })
    }
}
