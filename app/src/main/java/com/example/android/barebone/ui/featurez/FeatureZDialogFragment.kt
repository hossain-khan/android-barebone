package com.example.android.barebone.ui.featurez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.barebone.R
import com.example.android.barebone.databinding.DialogFeatureZBinding
import com.example.android.barebone.di.Injectable
import javax.inject.Inject

class FeatureZDialogFragment : DialogFragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: DialogFeatureZBinding
    lateinit var viewModel: FeatureZViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activity?.run {
            ViewModelProviders.of(this, viewModelFactory).get(FeatureZViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_feature_z, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }
}
