package com.jsonstatham.hackathonapp.di.Auth

import com.jsonstatham.hackathonapp.Api.LogRegApi
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

@Module
class AuthModule {

    @AuthScope
    @Provides
    fun provideCS() : CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }

    @AuthScope
    @Provides
    fun provideRegApi(ret : Retrofit) : LogRegApi {
        return ret.create(LogRegApi::class.java)
    }
}