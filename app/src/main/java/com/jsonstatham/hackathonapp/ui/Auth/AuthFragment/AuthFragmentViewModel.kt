package com.jsonstatham.hackathonapp.ui.Auth.AuthFragment

import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.Api.LogRegApi
import com.jsonstatham.hackathonapp.Api.Models.Auth.Response
import com.jsonstatham.hackathonapp.Api.Models.Auth.ResponseLogBody
import com.jsonstatham.hackathonapp.Manager
import com.jsonstatham.hackathonapp.Models.Auth.Auth.StatusDataAuth
import com.jsonstatham.hackathonapp.await
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class AuthFragmentViewModel @Inject constructor(
    private val api: LogRegApi
    , private val manager: Manager
    , @field:Named("auth_coroutine") private val coroutineScope: CoroutineScope
) : ViewModel() {

    private var netWorkJob: Job? = null

    fun tryLogin(userName: String, password: String) {

        if (netWorkJob !== null) netWorkJob?.cancel()
        netWorkJob = coroutineScope.launch {
            try {
                manager.authStatus.postValue(StatusDataAuth.onSigning())
                val mapKey: MutableMap<String, String> = TreeMap()
                mapKey["email"] = userName
                mapKey["password"] = password
                val response = api.loginUser(mapKey).await()
                manager.authStatus.postValue(StatusDataAuth.onLogin(response))
            } catch (e: IllegalArgumentException) {
                manager.authStatus.postValue(StatusDataAuth.onError("No user"))
            } catch (e1: IOException) {
                manager.authStatus.postValue(StatusDataAuth.onError("No inet connection"))
            } finally {
                netWorkJob = null
            }
        }
    }

    fun onStopWorking() {
        netWorkJob?.cancel()
    }

}