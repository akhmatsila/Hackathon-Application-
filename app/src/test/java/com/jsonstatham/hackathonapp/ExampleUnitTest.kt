package com.jsonstatham.hackathonapp

import com.jsonstatham.hackathonapp.Api.ApiML
import com.jsonstatham.hackathonapp.Api.LogRegApi
import org.junit.Test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val retrofitTest = Retrofit.Builder().baseUrl("http://192.168.0.172")
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiML::class.java)
        println(retrofitTest.getSh().execute().body().answer)
        val response = retrofitTest.getWeakGet("59.916037","30.318972","shop").execute().body()
        println(response.dis_id)
        println(response.dis_name)
        println(response.female_age)
        println(response.female_count)
        println(response.item_count)
        println(response.koeff)
        println(response.male_age)
        println(response.rent_val)
        println(response.male_count)



        //print(retrofitTest.getAdress("59.916037","30.318972").execute().body().Street  )

    }
}
