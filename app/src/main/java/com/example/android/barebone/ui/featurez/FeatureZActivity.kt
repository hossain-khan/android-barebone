package com.example.android.barebone.ui.featurez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityFeatureZBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class FeatureZActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FeatureZViewModel
    private lateinit var binding: ActivityFeatureZBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feature_z)


        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeatureZViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}
