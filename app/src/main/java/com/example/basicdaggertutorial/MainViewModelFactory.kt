package com.example.basicdaggertutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * ViewModelProvider.Factory: pass objects in a ViewModel’s constructor.
 */
@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor (private val api: Api) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}