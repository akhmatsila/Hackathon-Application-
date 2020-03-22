package com.jsonstatham.hackathonapp.ui.Main.Search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsonstatham.hackathonapp.Api.ApiML
import com.jsonstatham.hackathonapp.Api.Models.Auth.Response
import com.jsonstatham.hackathonapp.Api.Models.Main.AdressModel
import com.jsonstatham.hackathonapp.Api.Models.Main.ZoneAnalyzis
import com.jsonstatham.hackathonapp.Models.ProcessionData
import com.jsonstatham.hackathonapp.await
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.IllegalArgumentException
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val api : ApiML,
    private val coroutineScope: CoroutineScope,
    private val zoneAnalyzis: LiveData<ProcessionData<ZoneAnalyzis>>,
    private val adress : LiveData<ProcessionData<Response>>
) : ViewModel() {

    private var job : Job? = null



    private fun startCoroutine( functor :suspend () -> Unit) {
        if (job !== null) job?.cancel()
        job = coroutineScope.launch{
            functor()
        }
    }

    fun getZoneAnalytics(lat : String , lon : String , category: String) {
        startCoroutine { getAnalytics(lat , lon , category) }
    }

    fun getMarkeredAdress(lat : String, lon: String) {
        startCoroutine { getAdress(lat, lon) }
    }

    private suspend fun getAnalytics(lat : String , lon : String , category: String) {
        try {
            castZoneAnalyzis().postValue(ProcessionData.onEvaluating())
            val response : ZoneAnalyzis = api.getWeakGet(lat , lon , category).await()
            castZoneAnalyzis().postValue(ProcessionData.onEvaluated(response))
        } catch (e : IOException) {
            castAdress().postValue(ProcessionData.onError("no inet connection"))
        } catch (e1 : Throwable){
            castAdress().postValue(ProcessionData.onError("no data"))
        }
        finally {
            job = null
        }
    }

    private suspend fun getAdress(lat : String , lon: String) {
        try {
            castAdress().postValue(ProcessionData.onEvaluating())
            val response = api.getAdress(lat , lon).await()
            castAdress().postValue(ProcessionData.onEvaluated(response))
        } catch (e : IOException) {
            castAdress().postValue(ProcessionData.onError("no inet connection"))
        } catch (e1 : Throwable){
            castAdress().postValue(ProcessionData.onError("unknown place"))
        }
        finally {
            job = null
        }
    }

    private fun castZoneAnalyzis() : MutableLiveData<ProcessionData<ZoneAnalyzis>> {
        return zoneAnalyzis as MutableLiveData
    }

    private fun castAdress() : MutableLiveData<ProcessionData<Response>> {
        return adress as MutableLiveData
    }

    fun getAnalyzis() : LiveData<ProcessionData<ZoneAnalyzis>> = zoneAnalyzis
    fun getAdress() : LiveData<ProcessionData<Response>> = adress

    fun stopWorking() {
        job?.cancel()
        job = null
    }
}