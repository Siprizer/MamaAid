package com.example.mamaaid.ui.screens

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mamaaid.data.Vaccine
import com.example.mamaaid.data.VaccineRepository
import kotlinx.coroutines.launch

@Composable
fun ChildScreen() {
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
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Child Care",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(12.dp)) // 0.3cm ≈ 12dp
        
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(2.dp)
                .background(Color.DarkGray)
        )

        Spacer(modifier = Modifier.height(20.dp)) // 0.5cm ≈ 20dp
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFFAB7),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = "Child health after birth includes a series of vaccinations to prevent disease. Uganda's standard immunization schedule requires multiple visits in the first 18 months. These vaccines are free under Uganda’s Ministry of Health and protect children against TB, polio, diphtheria, pertussis, tetanus, hepatitis B, meningitis, pneumonia, rotavirus, measles, and yellow fever.",
                fontSize = 14.sp,
                color = Color.Black,
                lineHeight = 20.sp
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
                            color = Color(0xFFFFFAB7),
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
                            text = "At birth",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        
                        Icon(
                            imageVector = if (isAtBirthExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = if (isAtBirthExpanded) "Collapse" else "Expand",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                
                // Dropdown content for At Birth
                if (isAtBirthExpanded) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFAB7),
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
                                    onExpandedChange = { isBcgExpanded = it }
                                )
                            }
                            
                            Spacer(modifier = Modifier.height(12.dp))
                            
                            // Polio-0 Vaccine section
                            val polio0Vaccine = vaccineData.find { it.id == "opv0_birth" }
                            if (polio0Vaccine != null) {
                                VaccineSection(
                                    vaccine = polio0Vaccine,
                                    isExpanded = isPolio0Expanded,
                                    onExpandedChange = { isPolio0Expanded = it }
                                )
                            } /*else {
                                // Placeholder for Polio-0 if not found in JSON
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                color = Color(0xFFFFD1E3),
                                                shape = if (isPolio0Expanded) RoundedCornerShape(
                                                    topStart = 8.dp,
                                                    topEnd = 8.dp
                                                ) else RoundedCornerShape(8.dp)
                                            )
                                            .clickable { isPolio0Expanded = !isPolio0Expanded }
                                            .padding(12.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "OPV-0 (oral polio, \"Polio 0\")",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            
                                            Icon(
                                                imageVector = if (isPolio0Expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                                contentDescription = if (isPolio0Expanded) "Collapse" else "Expand",
                                                tint = MaterialTheme.colorScheme.onSurface
                                            )
                                        }
                                    }
                                    
                                    // Polio-0 dropdown content (placeholder for JSON data)
                                    if (isPolio0Expanded) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(
                                                    color = Color(0xFFFFD1E3),
                                                    shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                                                )
                                                .padding(12.dp)
                                        ) {
                                            Column {
                                                Text(
                                                    text = "Vaccine information will be loaded from JSON file",
                                                    fontSize = 14.sp,
                                                    color = MaterialTheme.colorScheme.onSurface
                                                )
                                                Text(
                                                    text = "ID: polio_0_birth (to be added to JSON)",
                                                    fontSize = 12.sp,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            */
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 6 Weeks section
            VaccinationStageSection(
                title = "6 weeks",
                backgroundColor = Color(0xFFFFD1E3),
                vaccineData = vaccineData,
                isExpanded = is6WeeksExpanded,
                onExpandedChange = { is6WeeksExpanded = it },
                vaccines = listOf(
                    VaccineInfo("pentavalent1_6wks", "Pentavalent-1 (DPT, HepB, Hib)", isPentavalent1Expanded) { isPentavalent1Expanded = it },
                    VaccineInfo("opv1_6wks", "OPV1", isOpv1Expanded) { isOpv1Expanded = it },
                    VaccineInfo("pcv1_6wks", "PCV1 (pneumococcal)", isPcv1Expanded) { isPcv1Expanded = it },
                    VaccineInfo("rota1_6wks", "Rota1 (rotavirus)", isRota1Expanded) { isRota1Expanded = it }
                )
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 10 Weeks section
            VaccinationStageSection(
                title = "10 weeks",
                backgroundColor = Color(0xFFFFD1E3),
                vaccineData = vaccineData,
                isExpanded = is10WeeksExpanded,
                onExpandedChange = { is10WeeksExpanded = it },
                vaccines = listOf(
                    VaccineInfo("pentavalent2_10wks", "Pentavalent-2", isPentavalent2Expanded) { isPentavalent2Expanded = it },
                    VaccineInfo("opv2_10wks", "OPV2", isOpv2Expanded) { isOpv2Expanded = it },
                    VaccineInfo("pcv2_10wks", "PCV2", isPcv2Expanded) { isPcv2Expanded = it },
                    VaccineInfo("rota2_10wks", "Rota2", isRota2Expanded) { isRota2Expanded = it }
                )
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 14 Weeks section
            VaccinationStageSection(
                title = "14 weeks",
                backgroundColor = Color(0xFFFFD1E3),
                vaccineData = vaccineData,
                isExpanded = is14WeeksExpanded,
                onExpandedChange = { is14WeeksExpanded = it },
                vaccines = listOf(
                    VaccineInfo("pentavalent3_14wks", "Pentavalent-3", isPentavalent3Expanded) { isPentavalent3Expanded = it },
                    VaccineInfo("opv3_14wks", "OPV3", isOpv3Expanded) { isOpv3Expanded = it },
                    VaccineInfo("ipv_14wks", "IPV (injectable polio booster)", isIpvExpanded) { isIpvExpanded = it },
                    VaccineInfo("pcv3_14wks", "PCV3", isPcv3Expanded) { isPcv3Expanded = it }
                )
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 9 Months section
            VaccinationStageSection(
                title = "9 months",
                backgroundColor = Color(0xFFFFD1E3),
                vaccineData = vaccineData,
                isExpanded = is9MonthsExpanded,
                onExpandedChange = { is9MonthsExpanded = it },
                vaccines = listOf(
                    VaccineInfo("mr1_9months", "Measles–Rubella 1", isMeaslesRubella1Expanded) { isMeaslesRubella1Expanded = it },
                    VaccineInfo("yellowfever_9months", "Yellow Fever", isYellowFeverExpanded) { isYellowFeverExpanded = it }
                )
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 18 Months section
            VaccinationStageSection(
                title = "18 months",
                backgroundColor = Color(0xFFFFD1E3),
                vaccineData = vaccineData,
                isExpanded = is18MonthsExpanded,
                onExpandedChange = { is18MonthsExpanded = it },
                vaccines = listOf(
                    VaccineInfo("mr2_18months", "Measles–Rubella 2", isMeaslesRubella2Expanded) { isMeaslesRubella2Expanded = it }
                )
            )
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
    vaccines: List<VaccineInfo>
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
                    color = MaterialTheme.colorScheme.onSurface
                )
                
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
        
        // Dropdown content for the stage
        if (isExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = backgroundColor,
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
                                onExpandedChange = vaccineInfo.onExpandedChange
                            )
                        } else {
                            // Placeholder for vaccine not found in JSON
                            Column {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(
                                            color = Color(0xFF7EA1FF),
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
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        
                                        Icon(
                                            imageVector = if (vaccineInfo.isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                            contentDescription = if (vaccineInfo.isExpanded) "Collapse" else "Expand",
                                            tint = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                                
                                if (vaccineInfo.isExpanded) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                color = Color(0xFF7EA1FF),
                                                shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                                            )
                                            .padding(12.dp)
                                    ) {
                                        Column {
                                            Text(
                                                text = "Vaccine information will be loaded from JSON file",
                                                fontSize = 14.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Text(
                                                text = "ID: ${vaccineInfo.id} (to be added to JSON)",
                                                fontSize = 12.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
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
    onExpandedChange: (Boolean) -> Unit
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF7EA1FF),
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
                    color = MaterialTheme.colorScheme.onSurface
                )
                
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
        
        // Vaccine dropdown content
        if (isExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF7EA1FF),
                        shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                    )
                    .padding(12.dp)
            ) {
                Column {
                    Text(
                        text = "Title: ${vaccine.title}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Importance:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    vaccine.why_important.forEach { reason ->
                        Text(
                            text = "• $reason",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "What to Expect:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    vaccine.what_to_expect.forEach { expectation ->
                        Text(
                            text = "• $expectation",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Tips:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    vaccine.tips.forEach { tip ->
                        Text(
                            text = "• $tip",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
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