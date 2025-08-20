package com.example.mamaaid.data

data class AppTranslations(
    val language: String,
    val translations: Map<String, String>
)

object TranslationRepository {
    private val englishTranslations = mapOf(
        // Home Screen
        "app_title" to "MamaAid",
        "app_subtitle" to "Your pregnancy companion app",
        "mother" to "Mother",
        "child" to "Child",
        "luganda" to "Luganda",
        "english" to "English",
        
        // Navigation
        "home" to "Home",
        "faq" to "FAQ",
        "contact" to "Contact",
        
        // Mother Screen
        "mother_title" to "Mother's Health",
        "pregnancy_weeks" to "Pregnancy Weeks",
        "nutrition" to "Nutrition",
        "exercise" to "Exercise",
        "mental_health" to "Mental Health",
        "appointments" to "Appointments",
        "symptoms" to "Symptoms",
        "emergency" to "Emergency",
        
        // Child Screen
        "child_title" to "Child Development",
        "vaccines" to "Vaccines",
        "milestones" to "Milestones",
        "feeding" to "Feeding",
        "sleep" to "Sleep",
        "growth" to "Growth",
        "health_tips" to "Health Tips",
        
        // FAQ Screen
        "faq_title" to "Frequently Asked Questions",
        "faq_pregnancy" to "Pregnancy Questions",
        "faq_birth" to "Birth Questions",
        "faq_postpartum" to "Postpartum Questions",
        "faq_baby_care" to "Baby Care Questions",
        
        // Contact Screen
        "contact_title" to "Contact Information",
        "emergency_contact" to "Emergency Contact",
        "hospital" to "Hospital",
        "doctor" to "Doctor",
        "midwife" to "Midwife",
        
        // Common
        "back" to "Back",
        "next" to "Next",
        "save" to "Save",
        "cancel" to "Cancel",
        "ok" to "OK",
        "yes" to "Yes",
        "no" to "No",
        "loading" to "Loading...",
        "error" to "Error",
        "success" to "Success"
    )
    
    private val lugandaTranslations = mapOf(
        // Home Screen
        "app_title" to "MamaAid",
        "app_subtitle" to "Your pregnancy companion guide",
        "mother" to "Omukyala",
        "child" to "Omwana",
        "luganda" to "Luganda",
        "english" to "English",
        
        // Navigation
        "home" to "Ennyumba",
        "faq" to "Ebiyiga",
        "contact" to "Okukwatagana",
        
        // Mother Screen
        "mother_title" to "Obulamu bw'omukyala",
        "pregnancy_weeks" to "Emirundi gy'obukyala",
        "nutrition" to "Emmere",
        "exercise" to "Okukola Emizannyo",
        "mental_health" to "Obulamu bw'owoongo",
        "appointments" to "Enkolagana",
        "symptoms" to "Ebimenyetso",
        "emergency" to "Akabi",
        
        // Child Screen
        "child_title" to "Okukula kw'omwana",
        "vaccines" to "Eddagala ly'omwana",
        "milestones" to "Ebikolebwa",
        "feeding" to "Okulya",
        "sleep" to "Okwebaka",
        "growth" to "Okukula",
        "health_tips" to "Amaanyi g'Obulamu",
        
        // FAQ Screen
        "faq_title" to "Ebiyiga Ebiyitibwa",
        "faq_pregnancy" to "Ebiyiga ku Obukyala",
        "faq_birth" to "Ebiyiga ku Kuzzalwa",
        "faq_postpartum" to "Ebiyiga ku Nga Omwana Azze",
        "faq_baby_care" to "Ebiyiga ku Kukulira Omwana",
        
        // Contact Screen
        "contact_title" to "Amawulire g'Okukwatagana",
        "emergency_contact" to "Okukwatagana kwa Akabi",
        "hospital" to "Eddwaliro",
        "doctor" to "Omusawo",
        "midwife" to "Omukyala wa Bazzadde",
        
        // Common
        "back" to "Emabega",
        "next" to "Enyuma",
        "save" to "Okutereka",
        "cancel" to "Okulekera",
        "ok" to "Kale",
        "yes" to "Yee",
        "no" to "Nedda",
        "loading" to "Kikolebwa...",
        "error" to "Ensobi",
        "success" to "Kikole"
    )
    
    fun getTranslation(key: String, language: String): String {
        return when (language.lowercase()) {
            "luganda" -> lugandaTranslations[key] ?: englishTranslations[key] ?: key
            else -> englishTranslations[key] ?: key
        }
    }
    
    fun getAllTranslations(language: String): Map<String, String> {
        return when (language.lowercase()) {
            "luganda" -> lugandaTranslations
            else -> englishTranslations
        }
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
