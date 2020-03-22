package com.jsonstatham.hackathonapp

import androidx.lifecycle.MutableLiveData
import com.jsonstatham.hackathonapp.Api.Models.Auth.UserModel
import com.jsonstatham.hackathonapp.Api.Models.Main.ZoneAnalyzis
import com.jsonstatham.hackathonapp.Models.Auth.Auth.StatusDataAuth
import com.jsonstatham.hackathonapp.Models.ProcessionData

class Manager  {
    var authStatus : MutableLiveData<StatusDataAuth<UserModel>> = MutableLiveData()
    var lastZone : MutableLiveData<ProcessionData<ZoneAnalyzis>> = MutableLiveData()




}