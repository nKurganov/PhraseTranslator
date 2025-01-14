package com.example.phrasetranslator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.phrasetranslator.ui.theme.PhraseTranslatorTheme


class MainActivity : ComponentActivity() {
    private val viewModel: TranslatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhraseTranslatorTheme {
                TranslatorScreen(viewModel = viewModel, context = this)
            }
        }
    }
}
