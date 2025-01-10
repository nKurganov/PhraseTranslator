package com.example.phrasetranslator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslatorUI(
    viewModel: TranslatorViewModel,
    modifier: Modifier = Modifier
) {
    var expandedSource by remember { mutableStateOf(false) }
    var expandedTarget by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Выбор исходного языка
        ExposedDropdownMenuBox(
            expanded = expandedSource,
            onExpandedChange = { expandedSource = it }
        ) {
            TextField(
                readOnly = true,
                value = viewModel.languages[viewModel.sourceLanguage] ?: "Выбрать язык",
                onValueChange = {},
                label = { Text("Исходный язык") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedSource) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedSource,
                onDismissRequest = { expandedSource = false }
            ) {
                viewModel.languages.forEach { (code, name) ->
                    DropdownMenuItem(
                        text = { Text(text = name) },
                        onClick = {
                            viewModel.sourceLanguage = code
                            expandedSource = false
                        }
                    )
                }
            }
        }

        // Выбор целевого языка
        ExposedDropdownMenuBox(
            expanded = expandedTarget,
            onExpandedChange = { expandedTarget = it }
        ) {
            TextField(
                readOnly = true,
                value = viewModel.languages[viewModel.targetLanguage] ?: "Выбрать язык",
                onValueChange = {},
                label = { Text("Целевой язык") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedTarget) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedTarget,
                onDismissRequest = { expandedTarget = false }
            ) {
                viewModel.languages.forEach { (code, name) ->
                    DropdownMenuItem(
                        text = { Text(text = name) },
                        onClick = {
                            viewModel.targetLanguage = code
                            expandedTarget = false
                        }
                    )
                }
            }
        }

        // Поле для ввода текста
        OutlinedTextField(
            value = viewModel.inputText,
            onValueChange = { viewModel.inputText = it },
            label = { Text("Введите текст для перевода") },
            modifier = Modifier.fillMaxWidth()
        )

        // Кнопка для перевода
        Button(
            onClick = {
                viewModel.translate(folderId = "b1gun2l2egoi941d9gkj") // Ваш FOLDER_ID
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Перевести")
        }

        // Поле для отображения результата
        Text(
            text = viewModel.translatedText,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
