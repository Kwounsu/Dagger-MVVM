package com.example.basicdaggertutorial

import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesMainViewModelFactory(api: Api): MainViewModelFactory {
        return MainViewModelFactory(api)
    }
}