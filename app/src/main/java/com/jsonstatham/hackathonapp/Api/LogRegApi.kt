package com.jsonstatham.hackathonapp.Api

import com.jsonstatham.hackathonapp.Api.Models.Auth.Response
import com.jsonstatham.hackathonapp.Api.Models.Auth.ResponseLogBody
import com.jsonstatham.hackathonapp.Api.Models.Auth.ResponseRegBody
import com.jsonstatham.hackathonapp.Api.Models.Auth.UserModel
import retrofit2.Call
import retrofit2.http.*

interface LogRegApi {
    /**
     * @param email password nameUser
     */
    @POST("/User/RegisterUser")
    fun registrateUser(@QueryMap map: Map<String, String>): Call<Response>

    /**
     * @param email password
     */
    @POST("/User/Login")
    fun loginUser(@QueryMap map: Map<String, String>): Call<UserModel>

}