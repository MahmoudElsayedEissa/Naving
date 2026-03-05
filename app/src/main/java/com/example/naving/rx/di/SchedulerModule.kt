package com.example.naving.rx.di

import com.example.naving.rx.schedule.AppSchedulerProvider
import com.example.naving.rx.schedule.SchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SchedulerModule {

    @Binds
    @Singleton
    abstract fun bindSchedulerProvider(
        provider: AppSchedulerProvider
    ): SchedulerProvider
}