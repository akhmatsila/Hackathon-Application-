package com.jsonstatham.hackathonapp.ui.Auth.Registration

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.Api.LogRegApi
import com.jsonstatham.hackathonapp.Api.Models.Auth.Response
import com.jsonstatham.hackathonapp.Api.Models.Auth.ResponseRegBody
import com.jsonstatham.hackathonapp.Models.Auth.Registration.StatusDataReg
import com.jsonstatham.hackathonapp.await
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class RegistrationFragmentViewModel @Inject constructor(
    private val api: LogRegApi
    , private val coroutineScope: CoroutineScope
    , @field:Named("registration_coroutine") val liveData: LiveData<StatusDataReg<Response>>
) : ViewModel() {

    private var netWorkJob: Job? = null


    fun registrate(mail: String, userName: String, password: String) {
        if (netWorkJob !== null) netWorkJob?.cancel()
        netWorkJob = coroutineScope.launch {
            try {
                castLiveData().postValue(StatusDataReg.onRegistrating())
                val map: MutableMap<String, String> = TreeMap()
                map["email"] = mail
                map["user_name"] = userName
                map["password"] = password
                val response = api.registrateUser(map).await()
                if (response.answer!! == "NO") castLiveData().postValue(StatusDataReg.onDuplicate("this user already exist"))
                else castLiveData().postValue(StatusDataReg.onRegistrated(response))
            } catch (e: IOException) {
                castLiveData().postValue(StatusDataReg.onError("inet connection lost"))
            }
            finally {
                netWorkJob = null
            }

        }

    }

    fun onStopWorking() {
        netWorkJob?.cancel()
    }

    private fun castLiveData(): MutableLiveData<StatusDataReg<Response>> {
        return liveData as MutableLiveData
    }

}