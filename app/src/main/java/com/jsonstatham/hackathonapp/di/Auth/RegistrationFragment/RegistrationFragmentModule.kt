package com.jsonstatham.hackathonapp.di.Auth.RegistrationFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jsonstatham.hackathonapp.Api.Models.Auth.Response
import com.jsonstatham.hackathonapp.Models.Auth.Registration.StatusDataReg
import com.jsonstatham.hackathonapp.di.Auth.AuthScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@Module
class RegistrationFragmentModule {

    @RegistrationScope
    @Provides
    fun provideLiveData() : LiveData<StatusDataReg<Response>> {
        return MutableLiveData<StatusDataReg<Response>>()
    }

    @RegistrationScope
    @Named("registration_coroutine")
    @Provides
    fun provideCS() : CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }



}