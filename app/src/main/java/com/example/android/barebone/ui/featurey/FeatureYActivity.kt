package com.example.android.barebone.ui.featurey

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityFeatureYBinding
import dagger.android.AndroidInjection
import javax.inject.Inject
import timber.log.Timber

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

        setupIdeaList(binding.recyclerView)
    }

    private fun setupIdeaList(ideaList: RecyclerView) {

        val ideaListAdapter = FeatureYListAdapter { data ->
            Timber.d("Item Clicked: $data")
            viewModel.onItemClicked(data)
        }

        ideaList.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@FeatureYActivity)
            adapter = ideaListAdapter
        }

        viewModel.data.observe(this, Observer { result ->
            ideaListAdapter.submitList(result)
        })
    }
}
