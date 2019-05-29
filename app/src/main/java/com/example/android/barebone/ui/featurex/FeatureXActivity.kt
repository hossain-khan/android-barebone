package com.example.android.barebone.ui.featurex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.barebone.R

class FeatureXActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_x)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
