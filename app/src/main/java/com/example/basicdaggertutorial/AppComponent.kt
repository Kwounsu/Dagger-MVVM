package com.example.basicdaggertutorial

import com.example.basicdaggertutorial.repository.RepositoryModule
import com.example.basicdaggertutorial.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}