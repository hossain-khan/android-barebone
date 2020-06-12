package com.example.android.barebone.ui.featurey

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.barebone.ui.featurey.model.ItemModel

class FeatureYViewModel @ViewModelInject constructor() : ViewModel() {
    private val _data = MutableLiveData<List<ItemModel>>()
    val data: LiveData<List<ItemModel>> = _data

    private val sampleData = mutableListOf<ItemModel>()

    init {
        generateSampleDataSet()
        _data.value = sampleData.toList()
    }

    private fun generateSampleDataSet() {
        for (i in 1..20) {
            sampleData.add(ItemModel(i, "This is sample item with id: $i"))
        }
    }

    fun onItemClicked(item: ItemModel) {
        sampleData.remove(item)
        _data.value = sampleData.toList()
    }
}
