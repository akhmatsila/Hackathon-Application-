package com.jsonstatham.hackathonapp.di.Auth.AuthFragment

import com.jsonstatham.hackathonapp.di.Auth.AuthScope
import com.jsonstatham.hackathonapp.di.Auth.RegistrationFragment.RegistrationScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Named

@Module
class AuthFragmentModule {
    @AuthFragmentScope
    @Named("auth_coroutine")
    @Provides
    fun provideCS() : CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }
}