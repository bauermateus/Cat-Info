package com.mbs.catinfo

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://api.thecatapi.com/v1/images/"

        private fun getRetrofitClient(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }
        fun createGetService(): CatService {
            return getRetrofitClient().create(CatService::class.java)
        }
    }
}