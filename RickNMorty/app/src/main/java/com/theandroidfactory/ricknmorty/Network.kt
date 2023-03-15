package com.theandroidfactory.ricknmorty

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        // .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val service: Service by lazy {
        retrofit.create(Service::class.java)
    }
    val client = Client(service)
}

