package com.example.mamaaid.data

import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VaccineRepository(private val context: Context) {
    
    private val json = Json { ignoreUnknownKeys = true }
    
    suspend fun loadVaccineData(): VaccineData {
        return withContext(Dispatchers.IO) {
            val jsonString = context.assets.open("vaccines.json").bufferedReader().use { it.readText() }
            json.decodeFromString<VaccineData>(jsonString)
        }
    }
    
    fun getVaccineById(vaccineData: VaccineData, id: String): Vaccine? {
        return vaccineData.vaccines.find { it.id == id }
    }
} 