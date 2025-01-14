package com.example.phrasetranslator.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.phrasetranslator.data.TranslationEntity

@Dao
interface TranslationDao {
    @Insert
    suspend fun insertTranslation(translation: TranslationEntity)

    @Query("SELECT * FROM translations")
    suspend fun getAllTranslations(): List<TranslationEntity>
}