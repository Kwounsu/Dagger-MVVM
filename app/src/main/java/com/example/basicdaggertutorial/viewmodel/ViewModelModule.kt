package com.example.basicdaggertutorial.viewmodel

import com.example.basicdaggertutorial.Api
import com.example.basicdaggertutorial.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesMainViewModelFactory(userRepository: UserRepository): MainViewModelFactory {
        return MainViewModelFactory(userRepository)
    }
}