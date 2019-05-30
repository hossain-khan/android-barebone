package com.example.android.barebone.ui.featurey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityFeatureYBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * This activity shows how a recycler view is implemented using databinding and diffutils.
 */
class FeatureYActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FeatureYViewModel
    private lateinit var binding: ActivityFeatureYBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feature_y)


        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeatureYViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}
