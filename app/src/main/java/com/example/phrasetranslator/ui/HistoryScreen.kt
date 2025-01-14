package com.example.phrasetranslator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.phrasetranslator.data.TranslationEntity

@Composable
fun HistoryScreen(translations: List<TranslationEntity>, onBack: () -> Unit) {
    Column {
        Row {
            IconButton(onClick = onBack) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Назад")
            }
            Text("История переводов", modifier = Modifier.padding(16.dp))
        }
        if (translations.isEmpty()) {
            Text("Нет истории переводов", modifier = Modifier.padding(16.dp))
        } else {
            LazyColumn {
                items(translations) { translation ->
                    TranslationItem(translation = translation)
                }
            }
        }
    }
}

@Composable
fun TranslationItem(translation: TranslationEntity) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Исходный текст: ${translation.sourceText}")
        Text("Перевод: ${translation.translatedText}")
        Text("Языки: ${translation.sourceLanguage} -> ${translation.targetLanguage}")
    }
}