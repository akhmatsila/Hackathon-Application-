package com.jsonstatham.hackathonapp

import com.jsonstatham.hackathonapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}

suspend fun<T> Call<T>.await() : T = suspendCoroutine {
    enqueue(object:Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            it.resumeWithException(IOException(t))
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if(response === null) it.resumeWithException(IllegalArgumentException())
            else {
                if(response.isSuccessful) it.resume(response.body())
                else it.resumeWithException(IllegalArgumentException())
            }
        }

    })

}