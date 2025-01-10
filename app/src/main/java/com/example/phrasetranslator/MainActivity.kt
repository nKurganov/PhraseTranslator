package com.example.phrasetranslator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phrasetranslator.ui.theme.PhraseTranslatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhraseTranslatorTheme {
                PhraseTranslatorApp()
            }
        }
    }
}

@Composable
fun PhraseTranslatorApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        TranslatorScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun TranslatorScreen(modifier: Modifier = Modifier) {
    var inputText by remember { mutableStateOf("") }
    var translatedText by remember { mutableStateOf("Перевод: ") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Поле для ввода текста
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Введите текст для перевода") },
            modifier = Modifier.fillMaxWidth()
        )

        // Кнопка для перевода
        Button(
            onClick = {
                // Логика перевода текста
                translatedText = "Перевод: $inputText" // В будущем замените на вызов API
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Перевести")
        }

        // Поле для отображения результата
        Text(
            text = translatedText,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TranslatorScreenPreview() {
    PhraseTranslatorTheme {
        TranslatorScreen()
    }
}
