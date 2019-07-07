package com.example.android.barebone.ui.home.homefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.barebone.R

/**
 * Demo fragment for tab content.
 *
 * TODO: Move the fragment to it's own feature package.
 */
class FragmentC : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_content, container, false)
    }
}