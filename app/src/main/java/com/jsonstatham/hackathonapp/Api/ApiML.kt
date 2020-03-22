package com.jsonstatham.hackathonapp.Api


import com.jsonstatham.hackathonapp.Api.Models.Main.AdressModel
import com.jsonstatham.hackathonapp.Api.Models.Main.ZoneAnalyzis
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiML {

    @GET("/GeoData/GetGeoData/")
    fun getStat(
        @Query("lon") lon: Float,
        @Query("lat") lat: Float,
        @Query("category") cat: String
    ): Call<ZoneAnalyzis>

    @GET("/GeoData/GetGeoData/")
    fun get(
        @Query("lon") lon: Float,
        @Query("lat") lat: Float,
        @Query("category") cat: String
    ): Response<String>

    @GET("/GeoData/GetGeoData")
    fun getWeakGet(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("category") cat: String
    ): Call<ZoneAnalyzis>

    @GET("/GeoData/ReverseGeoCoding")
    fun getAdress(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Call<com.jsonstatham.hackathonapp.Api.Models.Auth.Response>

    @GET("/GeoData/ReverseGeoCoding?lat=59.916087&lon=30.318972")
    fun getShit() : Call<AdressModel>

    @GET("/GeoData/ReverseGeoCoding?lat=59.916087&lon=30.318972")
    fun getSh() : Call<com.jsonstatham.hackathonapp.Api.Models.Auth.Response>
}
