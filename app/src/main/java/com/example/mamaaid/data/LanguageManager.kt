package com.example.mamaaid.data

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class LanguageManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("language_prefs", Context.MODE_PRIVATE)
    
    var currentLanguage: String by mutableStateOf(getStoredLanguage())
        private set
    
    private fun getStoredLanguage(): String {
        return prefs.getString("current_language", "English") ?: "English"
    }
    
    fun setLanguage(language: String) {
        currentLanguage = language
        prefs.edit().putString("current_language", language).apply()
    }
    
    fun getTranslation(key: String): String {
        return TranslationRepository.getTranslation(key, currentLanguage)
    }
    
    fun getAllTranslations(): Map<String, String> {
        return TranslationRepository.getAllTranslations(currentLanguage)
    }
}

/*
*   Copyright 2025 Clarke Kiyingi

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*
* */
