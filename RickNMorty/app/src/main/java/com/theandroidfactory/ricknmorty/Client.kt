package com.theandroidfactory.ricknmorty

import retrofit2.Response

class Client(private val service: Service) {
    suspend fun getCharacterById(id: Int) = safeApiCall { service.getCharacterById(id) }

    private inline fun<T> safeApiCall(apiCall: () -> Response<T>): MyResponse<T> {
        return try {
            MyResponse.success(apiCall.invoke())
        } catch (e: java.lang.Exception) {
            MyResponse.failure(e)
        }
    }
}