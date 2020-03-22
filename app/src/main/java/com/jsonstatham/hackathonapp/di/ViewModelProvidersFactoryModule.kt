package com.jsonstatham.hackathonapp.di

import androidx.lifecycle.ViewModelProvider
import com.jsonstatham.hackathonapp.factories.ViewModelProvidersFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelProvidersFactoryModule {
    @Binds
    abstract fun bindFactory(viewModelProvidersFactory: ViewModelProvidersFactory) : ViewModelProvider.Factory
}