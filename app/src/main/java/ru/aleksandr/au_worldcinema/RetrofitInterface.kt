package ru.aleksandr.au_worldcinema

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitInterface {
    @POST("user/login")
    fun getAuth(@Body hashMap: HashMap<String, String>): Call<RetrofitDataclass>
    @GET("user/login")
    fun getOtvet(): Call<RetrofitDataclassPong>
}