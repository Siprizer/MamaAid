package com.mamaaid.pregnancy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mamaaid.pregnancy.data.LanguageManager
import com.mamaaid.pregnancy.ui.theme.BackgroundWithImage
import com.mamaaid.pregnancy.ui.theme.BabyBlue
import com.mamaaid.pregnancy.ui.theme.MintGreen
import com.mamaaid.pregnancy.ui.theme.SoftPink
import com.mamaaid.pregnancy.ui.theme.CharcoalGray
import com.mamaaid.pregnancy.ui.theme.White
import com.mamaaid.pregnancy.ui.theme.Typography

@Composable
fun HomeScreen(navController: NavController, languageManager: LanguageManager) {
    BackgroundWithImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        // MamaAid title with Baby Blue background
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
                    text = languageManager.getTranslation("app_title"),
                    style = Typography.headlineLarge,
                    color = White
                )

                Spacer(modifier = Modifier.height(12.dp)) // 0.3cm ≈ 12dp
                
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(2.dp)
                        .background(Color.DarkGray)
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp)) // 1cm ≈ 40dp
        
        // Subtitle with Mint Green background
        Box(
            modifier = Modifier
                .background(
                    color = MintGreen,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = languageManager.getTranslation("app_subtitle"),
                style = Typography.titleMedium,
                color = CharcoalGray
            )
        }
        
        // Another 1cm spacing before the boxes
        Spacer(modifier = Modifier.height(40.dp)) // 1cm ≈ 40dp
        
        // Two square boxes with rounded corners and shadows
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Mother box with Soft Pink background and shadow
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = SoftPink,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { navController.navigate("mother") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = languageManager.getTranslation("mother"),
                    style = Typography.headlineSmall,
                    color = CharcoalGray
                )
            }
            
            // Child box with Soft Pink background and shadow
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = SoftPink,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { navController.navigate("child") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = languageManager.getTranslation("child"),
                    style = Typography.titleMedium,
                    color = CharcoalGray
                )
            }
        }
        
        // 0.5cm spacing before language selection boxes
        Spacer(modifier = Modifier.height(20.dp)) // 0.5cm ≈ 20dp
        
        // Language selection boxes
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Luganda language box
            Box(
                modifier = Modifier
                    .size(120.dp, 60.dp) // Thinner height
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = if (languageManager.currentLanguage == "Luganda") SoftPink else SoftPink.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { languageManager.setLanguage("Luganda") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = languageManager.getTranslation("luganda"),
                    style = Typography.titleMedium,
                    color = CharcoalGray
                )
            }
            
            // English language box
            Box(
                modifier = Modifier
                    .size(120.dp, 60.dp) // Thinner height
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = if (languageManager.currentLanguage == "English") SoftPink else SoftPink.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { languageManager.setLanguage("English") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = languageManager.getTranslation("english"),
                    style = Typography.titleMedium,
                    color = CharcoalGray
                )
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