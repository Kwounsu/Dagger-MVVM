package com.example.basicdaggertutorial.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicdaggertutorial.repository.UserRepository
import javax.inject.Inject

/**
 * ViewModelProvider.Factory: pass objects in a ViewModel’s constructor.
 */
@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor (private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}