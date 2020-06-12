package com.example.android.barebone.ui.home.homefragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.android.barebone.R
import com.example.android.barebone.databinding.FragmentDemoContentABinding
import com.example.android.barebone.ui.featurex.FeatureXActivity
import com.example.android.barebone.ui.featurey.FeatureYActivity
import com.example.android.barebone.ui.featurez.FeatureZActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Demo fragment for tab content.
 *
 * This fragment is different than [FragmentB] and [FragmentC] in following ways:
 * - This has it's own view model [FragmentAViewModel] which is provided via injected factory.
 * - This loads a custom layout to test other activities.
 *
 * TODO: Move the fragment to it's own feature package.
 */
@AndroidEntryPoint
class FragmentA : Fragment() {
    companion object {
        fun createInstance(): FragmentA {
            return FragmentA()
        }
    }

    lateinit var binding: FragmentDemoContentABinding
    val viewModel: FragmentAViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("Got injected fragment's own viewmodel instance: %s.", viewModel)

        // Inflate the layout for this fragment using data binding and set the view model
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_demo_content_a, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeNavigationEvents(viewModel)
    }

    /**
     * TODO: This is an example of how LiveData can be used to navigate. Update accordingly.
     */
    private fun observeNavigationEvents(viewModel: FragmentAViewModel) {
        viewModel.featureXEvent.observe(viewLifecycleOwner, Observer {
            Timber.i("Launching feature X activity.")
            startActivity(Intent(activity, FeatureXActivity::class.java))
        })

        viewModel.featureYEvent.observe(viewLifecycleOwner, Observer {
            Timber.i("Launching feature Y activity.")
            startActivity(Intent(activity, FeatureYActivity::class.java))
        })

        viewModel.featureZEvent.observe(viewLifecycleOwner, Observer {
            Timber.i("Launching feature Z activity.")
            startActivity(Intent(activity, FeatureZActivity::class.java))
        })
    }
}
