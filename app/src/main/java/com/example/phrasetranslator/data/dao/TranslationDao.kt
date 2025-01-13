package com.example.phrasetranslator.data.dao // Укажите правильный пакет

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.phrasetranslator.data.TranslationEntity

@Dao
interface TranslationDao {
    @Insert
    suspend fun insertTranslation(translation: TranslationEntity)

    @Query("SELECT * FROM translations ORDER BY timestamp DESC")
    suspend fun getAllTranslations(): List<TranslationEntity>
}