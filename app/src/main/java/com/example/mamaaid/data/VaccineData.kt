package com.example.mamaaid.data

import kotlinx.serialization.Serializable

@Serializable
data class VaccineData(
    val vaccines: List<Vaccine>
)

@Serializable
data class Vaccine(
    val id: String,
    val age: String,
    val title: String,
    val why_important: List<String>,
    val what_to_expect: List<String>,
    val tips: List<String>
) 