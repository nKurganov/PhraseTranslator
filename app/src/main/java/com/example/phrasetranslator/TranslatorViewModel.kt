package com.example.phrasetranslator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phrasetranslator.network.ApiClient
import com.example.phrasetranslator.network.TranslationApi
import com.example.phrasetranslator.network.YandexTranslationRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class TranslatorViewModel : ViewModel() {
    var inputText by mutableStateOf("") // Следит за изменением текста
    var translatedText by mutableStateOf("Перевод появится здесь!") // Следит за изменением результата
    var sourceLanguage = "en" // Исходный язык
    var targetLanguage = "ru" // Целевой язык

    // Список доступных языков
    val languages = mapOf(
        "en" to "Английский",
        "ru" to "Русский",
        "es" to "Испанский",
        "fr" to "Французский",
        "de" to "Немецкий"
    )

    // Метод для выполнения перевода
    fun translate(folderId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Создание API клиента
                val api = ApiClient.instance.create(TranslationApi::class.java)

                // Формирование запроса
                val request = YandexTranslationRequest(
                    texts = listOf(inputText), // Текст для перевода
                    targetLanguageCode = targetLanguage, // Целевой язык
                    sourceLanguageCode = sourceLanguage, // Исходный язык
                    folderId = "b1gun2l2egoi941d9gkj" // Идентификатор каталога
                )

                // Выполнение запроса
                val response = api.translate(request)

                // Обновление UI с результатом
                withContext(Dispatchers.Main) {
                    translatedText = response.translations.firstOrNull()?.text ?: "Ошибка перевода"
                }
            } catch (e: Exception) {
                // Обработка ошибок
                withContext(Dispatchers.Main) {
                    translatedText = "Ошибка: ${e.message}"
                }
            }
        }
    }
}
