package com.example.phrasetranslator.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://translate.api.cloud.yandex.net/translate/v2/"
    private const val API_KEY = "AQVNx7tsI8Q94bBDTqKsOrq0FwL2Io1Q2S1q5CTa" // Замените на ваш API-ключ

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(YandexAuthInterceptor(API_KEY))
        .addInterceptor(loggingInterceptor)
        .build()

    val instance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

class YandexAuthInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Api-Key $apiKey")
            .build()
        return chain.proceed(request)
    }
}