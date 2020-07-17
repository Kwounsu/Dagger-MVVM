package com.example.basicdaggertutorial.repository

import com.example.basicdaggertutorial.Api
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(api: Api): UserRepository {
        return UserRepositoryImpl(api)
    }
}