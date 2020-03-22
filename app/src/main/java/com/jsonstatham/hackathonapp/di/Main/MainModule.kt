package com.jsonstatham.hackathonapp.di.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jsonstatham.hackathonapp.Api.ApiML
import com.jsonstatham.hackathonapp.Api.Models.Auth.Response
import com.jsonstatham.hackathonapp.Api.Models.Main.AdressModel
import com.jsonstatham.hackathonapp.Api.Models.Main.ZoneAnalyzis
import com.jsonstatham.hackathonapp.Models.ProcessionData
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideCS() : CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }

    @MainScope
    @Provides
    fun currentZoneAnalyzis() : LiveData<ProcessionData<ZoneAnalyzis>> {
        val answer  =  MutableLiveData<ProcessionData<ZoneAnalyzis>>()
        answer.value = ProcessionData.onNothing()
        return answer
    }

    @MainScope
    @Provides
    fun currentAdressName() : LiveData<ProcessionData<Response>> {
        val answer = MutableLiveData<ProcessionData<Response>>()
        answer.value = ProcessionData.onNothing()
        return answer
    }

    @MainScope
    @Provides
    fun provideApiMl(retrofit: Retrofit) : ApiML {
        return retrofit.create(ApiML::class.java)
    }
}