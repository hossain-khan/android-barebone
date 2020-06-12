package com.example.android.barebone.ui.featurex

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityFeatureXBinding
import com.example.android.barebone.ui.common.Result
import com.example.android.barebone.ui.extensions.onChanged
import dagger.hilt.android.AndroidEntryPoint

/**
 * This activity shows how web service API can be used via ViewModel.
 *
 * @see FeatureXViewModel
 */
@AndroidEntryPoint
class FeatureXActivity : AppCompatActivity() {

    private val viewModel: FeatureXViewModel by viewModels()
    private lateinit var binding: ActivityFeatureXBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feature_x)

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
