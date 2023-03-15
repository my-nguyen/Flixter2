package com.theandroidfactory.ricknmorty

class Repository {
    suspend fun getCharacterById(id: Int): Character? {
        val request = Network.client.getCharacterById(id)
        return if (request.failed || !request.isSuccessful) null else request.body
    }
}
