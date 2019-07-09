package com.example.android.barebone.ui.featurex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityFeatureXBinding
import com.example.android.barebone.ui.common.Result
import com.example.android.barebone.ui.extensions.onChanged
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * This activity shows how web service API can be used via ViewModel.
 *
 * @see FeatureXViewModel
 */
class FeatureXActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FeatureXViewModel
    private lateinit var binding: ActivityFeatureXBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feature_x)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeatureXViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.message.onChanged { result ->
            when (result) {
                is Result.Success -> {
                    binding.messageText.text = result.data
                }
                is Result.Error -> {
                    binding.messageText.text = result.exception.message
                }
            }
        }
    }
}
