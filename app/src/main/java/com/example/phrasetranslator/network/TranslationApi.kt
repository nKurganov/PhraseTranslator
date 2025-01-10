package com.example.phrasetranslator.network

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TranslationApi {
    @Headers("Content-Type: application/json")
    @POST("translate")
    suspend fun translate(@Body request: YandexTranslationRequest): YandexTranslationResponse
}
