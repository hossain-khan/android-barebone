package com.example.android.barebone.ui.featurez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.barebone.R
import com.example.android.barebone.databinding.ActivityFeatureZBinding
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * This activity shows how a fragment can be injected.
 *
 * @see FeatureZViewModel
 */
class FeatureZActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidFragmentInjector

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

        observeNavigationEvents(viewModel)
    }

    /**
     * TODO: This is an example of how LiveData can be used to navigate. Update accordingly.
     */
    private fun observeNavigationEvents(viewModel: FeatureZViewModel) {
        viewModel.showDialogEvent.observe(this, Observer {
            Timber.i("Showing dialog")
            val dialog = FeatureZDialogFragment()
            dialog.show(supportFragmentManager, "dialog")
        })
    }
}
