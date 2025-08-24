package com.mamaaid.pregnancy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mamaaid.pregnancy.data.LanguageManager
import com.mamaaid.pregnancy.data.Vaccine
import com.mamaaid.pregnancy.data.VaccineRepository
import com.mamaaid.pregnancy.ui.theme.BackgroundWithImage
import com.mamaaid.pregnancy.ui.theme.BabyBlue
import com.mamaaid.pregnancy.ui.theme.SoftPink
import com.mamaaid.pregnancy.ui.theme.WarmCream
import com.mamaaid.pregnancy.ui.theme.CharcoalGray
import com.mamaaid.pregnancy.ui.theme.White
import com.mamaaid.pregnancy.ui.theme.Typography

@Composable
fun ChildScreen(languageManager: LanguageManager) {
    val context = LocalContext.current
    val vaccineRepository = remember { VaccineRepository(context) }
    val coroutineScope = rememberCoroutineScope()
    
    var isAtBirthExpanded by remember { mutableStateOf(false) }
    var isBcgExpanded by remember { mutableStateOf(false) }
    var isPolio0Expanded by remember { mutableStateOf(false) }
    
    var is6WeeksExpanded by remember { mutableStateOf(false) }
    var is10WeeksExpanded by remember { mutableStateOf(false) }
    var is14WeeksExpanded by remember { mutableStateOf(false) }
    var is9MonthsExpanded by remember { mutableStateOf(false) }
    var is18MonthsExpanded by remember { mutableStateOf(false) }

    //6 weeks
    var isPentavalent1Expanded by remember { mutableStateOf(false) }
    var isOpv1Expanded by remember { mutableStateOf(false) }
    var isPcv1Expanded by remember { mutableStateOf(false) }
    var isRota1Expanded by remember { mutableStateOf(false) }
    
    // 10 weeks
    var isPentavalent2Expanded by remember { mutableStateOf(false) }
    var isOpv2Expanded by remember { mutableStateOf(false) }
    var isPcv2Expanded by remember { mutableStateOf(false) }
    var isRota2Expanded by remember { mutableStateOf(false) }
    
    // 14 weeks
    var isPentavalent3Expanded by remember { mutableStateOf(false) }
    var isOpv3Expanded by remember { mutableStateOf(false) }
    var isIpvExpanded by remember { mutableStateOf(false) }
    var isPcv3Expanded by remember { mutableStateOf(false) }
    
    // 9 months
    var isMeaslesRubella1Expanded by remember { mutableStateOf(false) }
    var isYellowFeverExpanded by remember { mutableStateOf(false) }
    
    // 18 months
    var isMeaslesRubella2Expanded by remember { mutableStateOf(false) }
    var vaccineData by remember { mutableStateOf<List<Vaccine>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }
    
    // Load vaccine data
    LaunchedEffect(Unit) {
        try {
            val data = vaccineRepository.loadVaccineData()
            vaccineData = data.vaccines
            isLoading = false
        } catch (e: Exception) {
            error = e.message
            isLoading = false
        }
    }
    
    BackgroundWithImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        // Child Care title in a curved corner box with Baby Blue background (matching home page)
        Box(
            modifier = Modifier
                .background(
                    color = BabyBlue,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = languageManager.getTranslation("child_title"),
                    style = Typography.headlineLarge,
                    color = White
                )
                
                // Dark gray underline with 0.3cm spacing
                Spacer(modifier = Modifier.height(12.dp)) // 0.3cm ≈ 12dp
                
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(2.dp)
                        .background(Color.DarkGray)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp)) // 0.5cm ≈ 20dp
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = BabyBlue,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = if (languageManager.currentLanguage == "Luganda") {
                    "Obulamu bw'omwana nga azze kikwatira eddagala ly'okuziyiza okuziyiza endwadde. Emirundi gya Uganda gy'okuziyiza gikyetaaga okukyalira emirundi mingi mu mirundi 18 egisooka. Eddagala lino lya bbeeyi mu Minisitule y'Obulamu ya Uganda era liziyiza abana ku TB, polio, diphtheria, pertussis, tetanus, hepatitis B, meningitis, pneumonia, rotavirus, measles, n'yellow fever."
                } else {
                    "Child health after birth includes a series of vaccinations to prevent disease. Uganda's standard immunization schedule requires multiple visits in the first 18 months. These vaccines are free under Uganda's Ministry of Health and protect children against TB, polio, diphtheria, pertussis, tetanus, hepatitis B, meningitis, pneumonia, rotavirus, measles, and yellow fever."
                },
                style = Typography.bodyMedium,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp)) // 0.5cm ≈ 20dp
        
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.primary
            )
        } else if (error != null) {
            Text(
                text = "Error loading vaccine data: $error",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            // At Birth section
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = SoftPink,
                            shape = if (isAtBirthExpanded) RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp
                            ) else RoundedCornerShape(8.dp)
                        )
                        .clickable { isAtBirthExpanded = !isAtBirthExpanded }
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (languageManager.currentLanguage == "Luganda") "Nga azze" else "At birth",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = CharcoalGray
                        )
                        
                        Icon(
                            imageVector = if (isAtBirthExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = if (isAtBirthExpanded) "Collapse" else "Expand",
                            tint = CharcoalGray
                        )
                    }
                }
                
                // Dropdown content for At Birth
                if (isAtBirthExpanded) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = WarmCream,
                                shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                            )
                            .padding(16.dp)
                    ) {
                        Column {
                            // BCG Vaccine section
                            val bcgVaccine = vaccineData.find { it.id == "bcg_birth" }
                            if (bcgVaccine != null) {
                                VaccineSection(
                                    vaccine = bcgVaccine,
                                    isExpanded = isBcgExpanded,
                                    onExpandedChange = { isBcgExpanded = it },
                                    languageManager = languageManager
                                )
                            }
                            
                            Spacer(modifier = Modifier.height(12.dp))
                            
                            // Polio-0 Vaccine section
                            val polio0Vaccine = vaccineData.find { it.id == "opv0_birth" }
                            if (polio0Vaccine != null) {
                                VaccineSection(
                                    vaccine = polio0Vaccine,
                                    isExpanded = isPolio0Expanded,
                                    onExpandedChange = { isPolio0Expanded = it },
                                    languageManager = languageManager
                                )
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 6 Weeks section
            VaccinationStageSection(
                title = if (languageManager.currentLanguage == "Luganda") "Emirundi 6" else "6 weeks",
                backgroundColor = SoftPink,
                vaccineData = vaccineData,
                isExpanded = is6WeeksExpanded,
                onExpandedChange = { is6WeeksExpanded = it },
                vaccines = listOf(
                    VaccineInfo("pentavalent1_6wks", "Pentavalent-1 (DPT, HepB, Hib)", isPentavalent1Expanded) { isPentavalent1Expanded = it },
                    VaccineInfo("opv1_6wks", "OPV1", isOpv1Expanded) { isOpv1Expanded = it },
                    VaccineInfo("pcv1_6wks", "PCV1 (pneumococcal)", isPcv1Expanded) { isPcv1Expanded = it },
                    VaccineInfo("rota1_6wks", "Rota1 (rotavirus)", isRota1Expanded) { isRota1Expanded = it }
                ),
                languageManager = languageManager
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 10 Weeks section
            VaccinationStageSection(
                title = if (languageManager.currentLanguage == "Luganda") "Emirundi 10" else "10 weeks",
                backgroundColor = SoftPink,
                vaccineData = vaccineData,
                isExpanded = is10WeeksExpanded,
                onExpandedChange = { is10WeeksExpanded = it },
                vaccines = listOf(
                    VaccineInfo("pentavalent2_10wks", "Pentavalent-2", isPentavalent2Expanded) { isPentavalent2Expanded = it },
                    VaccineInfo("opv2_10wks", "OPV2", isOpv2Expanded) { isOpv2Expanded = it },
                    VaccineInfo("pcv2_10wks", "PCV2", isPcv2Expanded) { isPcv2Expanded = it },
                    VaccineInfo("rota2_10wks", "Rota2", isRota2Expanded) { isRota2Expanded = it }
                ),
                languageManager = languageManager
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 14 Weeks section
            VaccinationStageSection(
                title = if (languageManager.currentLanguage == "Luganda") "Emirundi 14" else "14 weeks",
                backgroundColor = SoftPink,
                vaccineData = vaccineData,
                isExpanded = is14WeeksExpanded,
                onExpandedChange = { is14WeeksExpanded = it },
                vaccines = listOf(
                    VaccineInfo("pentavalent3_14wks", "Pentavalent-3", isPentavalent3Expanded) { isPentavalent3Expanded = it },
                    VaccineInfo("opv3_14wks", "OPV3", isOpv3Expanded) { isOpv3Expanded = it },
                    VaccineInfo("ipv_14wks", "IPV (injectable polio booster)", isIpvExpanded) { isIpvExpanded = it },
                    VaccineInfo("pcv3_14wks", "PCV3", isPcv3Expanded) { isPcv3Expanded = it }
                ),
                languageManager = languageManager
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 9 Months section
            VaccinationStageSection(
                title = if (languageManager.currentLanguage == "Luganda") "Emyezi 9" else "9 months",
                backgroundColor = SoftPink,
                vaccineData = vaccineData,
                isExpanded = is9MonthsExpanded,
                onExpandedChange = { is9MonthsExpanded = it },
                vaccines = listOf(
                    VaccineInfo("mr1_9months", "Measles–Rubella 1", isMeaslesRubella1Expanded) { isMeaslesRubella1Expanded = it },
                    VaccineInfo("yellowfever_9months", "Yellow Fever", isYellowFeverExpanded) { isYellowFeverExpanded = it }
                ),
                languageManager = languageManager
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 18 Months section
            VaccinationStageSection(
                title = if (languageManager.currentLanguage == "Luganda") "Emyezi 18" else "18 months",
                backgroundColor = SoftPink,
                vaccineData = vaccineData,
                isExpanded = is18MonthsExpanded,
                onExpandedChange = { is18MonthsExpanded = it },
                vaccines = listOf(
                    VaccineInfo("mr2_18months", "Measles–Rubella 2", isMeaslesRubella2Expanded) { isMeaslesRubella2Expanded = it }
                ),
                languageManager = languageManager
            )
        }
    }
    }
}

data class VaccineInfo(
    val id: String,
    val title: String,
    val isExpanded: Boolean,
    val onExpandedChange: (Boolean) -> Unit
)

@Composable
fun VaccinationStageSection(
    title: String,
    backgroundColor: Color,
    vaccineData: List<Vaccine>,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    vaccines: List<VaccineInfo>,
    languageManager: LanguageManager
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = backgroundColor,
                    shape = if (isExpanded) RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 8.dp
                    ) else RoundedCornerShape(8.dp)
                )
                .clickable { onExpandedChange(!isExpanded) }
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = CharcoalGray
                )
                
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                    tint = CharcoalGray
                )
            }
        }
        
        // Dropdown content for the stage
        if (isExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = WarmCream,
                        shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                    )
                    .padding(16.dp)
            ) {
                Column {
                    vaccines.forEach { vaccineInfo ->
                        val vaccine = vaccineData.find { it.id == vaccineInfo.id }
                        if (vaccine != null) {
                            VaccineSection(
                                vaccine = vaccine,
                                isExpanded = vaccineInfo.isExpanded,
                                onExpandedChange = vaccineInfo.onExpandedChange,
                                languageManager = languageManager
                            )
                        } else {
                            // Placeholder for vaccine not found in JSON
                            Column {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(
                                            color = BabyBlue,
                                            shape = if (vaccineInfo.isExpanded) RoundedCornerShape(
                                                topStart = 8.dp,
                                                topEnd = 8.dp
                                            ) else RoundedCornerShape(8.dp)
                                        )
                                        .clickable { vaccineInfo.onExpandedChange(!vaccineInfo.isExpanded) }
                                        .padding(12.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = vaccineInfo.title,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = CharcoalGray
                                        )
                                        
                                        Icon(
                                            imageVector = if (vaccineInfo.isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                            contentDescription = if (vaccineInfo.isExpanded) "Collapse" else "Expand",
                                            tint = CharcoalGray
                                        )
                                    }
                                }
                                
                                if (vaccineInfo.isExpanded) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                color = BabyBlue,
                                                shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                                            )
                                            .padding(12.dp)
                                    ) {
                                        Column {
                                            Text(
                                                text = "Vaccine information will be loaded from JSON file",
                                                fontSize = 14.sp,
                                                color = CharcoalGray
                                            )
                                            Text(
                                                text = "ID: ${vaccineInfo.id} (to be added to JSON)",
                                                fontSize = 12.sp,
                                                color = CharcoalGray
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        
                        if (vaccineInfo != vaccines.last()) {
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VaccineSection(
    vaccine: Vaccine,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    languageManager: LanguageManager
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = WarmCream,
                    shape = if (isExpanded) RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 8.dp
                    ) else RoundedCornerShape(8.dp)
                )
                .clickable { onExpandedChange(!isExpanded) }
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = vaccine.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = CharcoalGray
                )
                
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                    tint = CharcoalGray
                )
            }
        }
        
        // Vaccine dropdown content
        if (isExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = WarmCream,
                        shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                    )
                    .padding(12.dp)
            ) {
                Column {
                    Text(
                        text = "Title: ${vaccine.title}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CharcoalGray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Importance:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CharcoalGray
                    )
                    vaccine.why_important.forEach { reason ->
                        Text(
                            text = "• $reason",
                            fontSize = 14.sp,
                            color = CharcoalGray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "What to Expect:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CharcoalGray
                    )
                    vaccine.what_to_expect.forEach { expectation ->
                        Text(
                            text = "• $expectation",
                            fontSize = 14.sp,
                            color = CharcoalGray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Tips:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = CharcoalGray
                    )
                    vaccine.tips.forEach { tip ->
                        Text(
                            text = "• $tip",
                            fontSize = 14.sp,
                            color = CharcoalGray
                        )
                    }
                }
            }
        }
    }
}

/*
*   Copyright 2025 Clarke K.

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