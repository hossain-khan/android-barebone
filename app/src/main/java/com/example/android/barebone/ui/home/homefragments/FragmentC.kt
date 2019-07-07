package com.example.android.barebone.ui.home.homefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.barebone.R
import com.example.android.barebone.di.Injectable
import com.example.android.barebone.ui.home.HomeViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * Demo fragment for tab content.
 *
 * TODO: Move the fragment to it's own feature package.
 */
class FragmentC : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activity?.run {
            ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        Timber.d("Got injected parent's viewmodel instance: %s.", viewModel)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_content, container, false)
    }
}