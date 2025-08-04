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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MotherScreen() {
    var isFirstTrimesterExpanded by remember { mutableStateOf(false) }
    var isSecondTrimesterExpanded by remember { mutableStateOf(false) }
    var isThirdTrimesterExpanded by remember { mutableStateOf(false) }
    var isAfterBirthExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mother Care",
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
                text = "Pregnant women need more healthy food to help their baby grow well. Eat leafy greens, fruits, beans, nuts, milk, meat, or fish every day. Eat iron-rich foods like beans or meat. Drink clean water and eat one extra snack each day during pregnancy, and two while breastfeeding.",
                fontSize = 14.sp,
                color = Color.Black,
                lineHeight = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp)) // 0.5cm ≈ 20dp

        // First trimester section
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFFFD1E3),
                        shape = if (isFirstTrimesterExpanded) RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp
                        ) else RoundedCornerShape(8.dp)
                    )
                    .clickable { isFirstTrimesterExpanded = !isFirstTrimesterExpanded }
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "First trimester",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Icon(
                        imageVector = if (isFirstTrimesterExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (isFirstTrimesterExpanded) "Collapse" else "Expand",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Dropdown content
            if (isFirstTrimesterExpanded) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFD1E3),
                            shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                        )
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "• Morning sickness is common in early pregnancy.",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "• Eat small, bland snacks (like porridge or toast) and use ginger or citrus (lemon/orange) to ease nausea.",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "• Do not skip meals.",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "• Focus on folate-rich foods (spinach, pumpkin leaves, beans, peas) and drink plenty of water.",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                                     }
             }
         }
         
         Spacer(modifier = Modifier.height(16.dp))
         
         // Second trimester section
         Column {
             Box(
                 modifier = Modifier
                     .fillMaxWidth()
                     .background(
                         color = Color(0xFFFFD1E3),
                         shape = if (isSecondTrimesterExpanded) RoundedCornerShape(
                             topStart = 8.dp,
                             topEnd = 8.dp
                         ) else RoundedCornerShape(8.dp)
                     )
                     .clickable { isSecondTrimesterExpanded = !isSecondTrimesterExpanded }
                     .padding(16.dp)
             ) {
                 Row(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.SpaceBetween,
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Text(
                         text = "Second trimester",
                         fontSize = 18.sp,
                         fontWeight = FontWeight.Medium,
                         color = MaterialTheme.colorScheme.onSurface
                     )
 
                     Icon(
                         imageVector = if (isSecondTrimesterExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                         contentDescription = if (isSecondTrimesterExpanded) "Collapse" else "Expand",
                         tint = MaterialTheme.colorScheme.onSurface
                     )
                 }
             }
 
             // Dropdown content
             if (isSecondTrimesterExpanded) {
                 Box(
                     modifier = Modifier
                         .fillMaxWidth()
                         .background(
                             color = Color(0xFFFFD1E3),
                             shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                         )
                         .padding(16.dp)
                 ) {
                     Column {
                         Text(
                             text = "• Nutrient and calorie needs increase.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Continue a varied diet and add one extra snack per day.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Good protein sources include beans, eggs, fish (tilapia) or lean meat, and groundnuts.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Eat iron-rich foods (meat, liver, beans, dark leafy greens) with vitamin C foods (mango, pawpaw, tomatoes) to boost absorption.",
                             fontSize = 13.4.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Keep eating carbohydrates (maize, millet, rice, cassava, bananas) for energy.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Drink clean water and practice good hygiene to prevent illness.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                     }
                 }
             }
         }
         
         Spacer(modifier = Modifier.height(16.dp))
         
         // Third trimester section
         Column {
             Box(
                 modifier = Modifier
                     .fillMaxWidth()
                     .background(
                         color = Color(0xFFFFD1E3),
                         shape = if (isThirdTrimesterExpanded) RoundedCornerShape(
                             topStart = 8.dp,
                             topEnd = 8.dp
                         ) else RoundedCornerShape(8.dp)
                     )
                     .clickable { isThirdTrimesterExpanded = !isThirdTrimesterExpanded }
                     .padding(16.dp)
             ) {
                 Row(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.SpaceBetween,
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Text(
                         text = "Third trimester",
                         fontSize = 18.sp,
                         fontWeight = FontWeight.Medium,
                         color = MaterialTheme.colorScheme.onSurface
                     )
 
                     Icon(
                         imageVector = if (isThirdTrimesterExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                         contentDescription = if (isThirdTrimesterExpanded) "Collapse" else "Expand",
                         tint = MaterialTheme.colorScheme.onSurface
                     )
                 }
             }
 
             // Dropdown content
             if (isThirdTrimesterExpanded) {
                 Box(
                     modifier = Modifier
                         .fillMaxWidth()
                         .background(
                             color = Color(0xFFFFD1E3),
                             shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                         )
                         .padding(16.dp)
                 ) {
                     Column {
                         Text(
                             text = "• Continue the extra meal/snack.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Prioritize calcium (for baby's bone growth) and protein.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Sources of calcium include milk, eggs, small fish (with bones), or beans.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Avoid spicy or fatty foods that cause heartburn and eat slowly.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Include fiber-rich foods (whole grains, fruits, vegetables) to prevent constipation.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Rest often and sleep propped up if needed to ease discomfort.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                     }
                 }
             }
         }
        
        Spacer(modifier = Modifier.height(16.dp))
        
         // After Birth (Breastfeeding) section
         Column {
             Box(
                 modifier = Modifier
                     .fillMaxWidth()
                     .background(
                         color = Color(0xFFFFD1E3),
                         shape = if (isAfterBirthExpanded) RoundedCornerShape(
                             topStart = 8.dp,
                             topEnd = 8.dp
                         ) else RoundedCornerShape(8.dp)
                     )
                     .clickable { isAfterBirthExpanded = !isAfterBirthExpanded }
                     .padding(16.dp)
             ) {
                 Row(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.SpaceBetween,
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Text(
                         text = "After Birth (Breastfeeding)",
                         fontSize = 18.sp,
                         fontWeight = FontWeight.Medium,
                         color = MaterialTheme.colorScheme.onSurface
                     )
 
                     Icon(
                         imageVector = if (isAfterBirthExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                         contentDescription = if (isAfterBirthExpanded) "Collapse" else "Expand",
                         tint = MaterialTheme.colorScheme.onSurface
                     )
                 }
             }
 
             // Dropdown content
             if (isAfterBirthExpanded) {
                 Box(
                     modifier = Modifier
                         .fillMaxWidth()
                         .background(
                             color = Color(0xFFFFD1E3),
                             shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                         )
                         .padding(16.dp)
                 ) {
                     Column {
                         Text(
                             text = "• After birth, a breastfeeding mother needs about two extra snacks/meals per day.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Continue taking iron supplements (usually for 3 months after birth) and include vitamin A–rich foods or supplements.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = "• Drink plenty of fluids (water, soup, milk) to support milk production.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                         Spacer(modifier = Modifier.height(8.dp))
        Text(
                             text = "• The mother should rest and eat well to regain strength.",
                             fontSize = 14.sp,
                             color = MaterialTheme.colorScheme.onSurface
                         )
                     }
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