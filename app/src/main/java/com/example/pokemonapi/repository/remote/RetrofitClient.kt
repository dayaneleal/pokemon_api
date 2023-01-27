package com.example.pokemonapi.repository.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    companion object {

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        private fun getRetrofitInstance(): Retrofit {

            val http = OkHttpClient.Builder()

            if(!::INSTANCE.isInitialized) {

                synchronized(RetrofitClient::class) {
                    INSTANCE = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(http.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }

            return INSTANCE

        }

        fun <T> getService(serviceClass: Class<T>): T {
            return getRetrofitInstance().create(serviceClass)
        }

    }
}