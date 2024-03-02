package ru.aleksandr.au_worldcinema

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://mskko2021.mad.hakta.pro/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
