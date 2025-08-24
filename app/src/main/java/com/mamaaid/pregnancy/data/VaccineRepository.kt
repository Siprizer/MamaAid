package com.mamaaid.pregnancy.data

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