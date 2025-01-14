package com.example.phrasetranslator

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.phrasetranslator.data.TranslationEntity
import com.example.phrasetranslator.ui.HistoryScreen

@Composable
fun TranslatorScreen(viewModel: TranslatorViewModel, context: Context) {
    var showHistory by remember { mutableStateOf(false) }
    var translations by remember { mutableStateOf(emptyList<TranslationEntity>()) }

    if (showHistory) {
        HistoryScreen(
            translations = translations,
            onBack = { showHistory = false }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Выбор исходного языка
            OutlinedTextField(
                value = viewModel.inputText,
                onValueChange = { viewModel.inputText = it },
                label = { Text("Введите текст для перевода") },
                modifier = Modifier.fillMaxWidth()
            )

            // Кнопка перевода
            Button(
                onClick = {
                    viewModel.translate(folderId = "b1gun2l2egoi941d9gkj")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Перевести")
            }

            // Результат перевода
            Text(
                text = viewModel.translatedText,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Кнопка истории переводов
            Button(
                onClick = {
                    viewModel.getTranslations {
                        translations = it
                        showHistory = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("История переводов")
            }
        }
    }
}