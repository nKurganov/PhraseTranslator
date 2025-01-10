package com.example.phrasetranslator.network

// Модель запроса к API Яндекс
data class YandexTranslationRequest(
    val texts: List<String>,         // Список текстов для перевода
    val targetLanguageCode: String,  // Целевой язык
    val sourceLanguageCode: String?, // Исходный язык (может быть null, если автоопределение)
    val folderId: String             // ID каталога (FOLDER_ID)
)

// Модель ответа от API Яндекс
data class YandexTranslationResponse(
    val translations: List<Translation>
)

// Переведённый текст
data class Translation(
    val text: String // Переведённый текст
)
