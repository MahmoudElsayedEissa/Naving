package com.example.naving.rx.di

import com.example.naving.rx.data.repository.RequestsRepositoryImplementation
import com.example.naving.rx.domain.repository.RequestsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRequestsRepository(
        impl: RequestsRepositoryImplementation
    ): RequestsRepository
}