package com.theandroidfactory.ricknmorty

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<Character>
}