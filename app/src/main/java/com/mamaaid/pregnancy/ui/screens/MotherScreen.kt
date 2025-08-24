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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mamaaid.pregnancy.data.LanguageManager
import com.mamaaid.pregnancy.ui.theme.BackgroundWithImage
import com.mamaaid.pregnancy.ui.theme.BabyBlue
import com.mamaaid.pregnancy.ui.theme.SoftPink
import com.mamaaid.pregnancy.ui.theme.WarmCream
import com.mamaaid.pregnancy.ui.theme.CharcoalGray
import com.mamaaid.pregnancy.ui.theme.White
import com.mamaaid.pregnancy.ui.theme.Typography

@Composable
fun MotherScreen(languageManager: LanguageManager) {
    var isFirstTrimesterExpanded by remember { mutableStateOf(false) }
    var isSecondTrimesterExpanded by remember { mutableStateOf(false) }
    var isThirdTrimesterExpanded by remember { mutableStateOf(false) }
    var isAfterBirthExpanded by remember { mutableStateOf(false) }

    BackgroundWithImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        // Mother's Health title in a curved corner box with Baby Blue background (matching home page)
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
                    text = languageManager.getTranslation("mother_title"),
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
                    "Abakazi abakula omwana bakyetaaga emmere ennungi okusobola okusobozesa omwana waabwe okukula bulungi. Lya amatunda, emmere, ebijanjaalo, ensigo, amata, ennyama, oba ennyanja buli lunaku. Lya emmere etono nk'ebijanjaalo oba ennyama. Nnywa amazzi amalungi era lya emmere emu eyongera buli lunaku nga ukula omwana, era bbiri nga onyonya."
                } else {
                    "Pregnant women need more healthy food to help their baby grow well. Eat leafy greens, fruits, beans, nuts, milk, meat, or fish every day. Eat iron-rich foods like beans or meat. Drink clean water and eat one extra snack each day during pregnancy, and two while breastfeeding."
                },
                style = Typography.bodyMedium,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp)) // 0.5cm ≈ 20dp

        // First trimester section
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = SoftPink,
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
                        text = if (languageManager.currentLanguage == "Luganda") "Emirundi gya Obukyala 1-3" else "First trimester",
                        style = Typography.titleMedium,
                        color = CharcoalGray
                    )

                    Icon(
                        imageVector = if (isFirstTrimesterExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (isFirstTrimesterExpanded) "Collapse" else "Expand",
                        tint = CharcoalGray
                    )
                }
            }

            // Dropdown content
            if (isFirstTrimesterExpanded) {
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
                        Text(
                            text = if (languageManager.currentLanguage == "Luganda") {
                                "• Okusiba kw'ensulo kikolebwa mu bukyala obw'ensolo."
                            } else {
                                "• Morning sickness is common in early pregnancy."
                            },
                            style = Typography.bodyMedium,
                            color = CharcoalGray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (languageManager.currentLanguage == "Luganda") {
                                "• Lya emmere etono, etonotono (nk'omugaati oba toast) era kozesa ginger oba citrus (lemon/orange) okuleetawo okusiba."
                            } else {
                                "• Eat small, bland snacks (like porridge or toast) and use ginger or citrus (lemon/orange) to ease nausea."
                            },
                            fontSize = 14.sp,
                            color = CharcoalGray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (languageManager.currentLanguage == "Luganda") {
                                "• Toleka emmere."
                            } else {
                                "• Do not skip meals."
                            },
                            fontSize = 14.sp,
                            color = CharcoalGray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (languageManager.currentLanguage == "Luganda") {
                                "• Lya emmere eziwera folate (spinach, pumpkin leaves, beans, peas) era nnywa amazzi amangi."
                            } else {
                                "• Focus on folate-rich foods (spinach, pumpkin leaves, beans, peas) and drink plenty of water."
                            },
                            fontSize = 14.sp,
                            color = CharcoalGray
                        )
                    }
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
                         color = SoftPink,
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
                         text = if (languageManager.currentLanguage == "Luganda") "Emirundi gya Obukyala 4-6" else "Second trimester",
                         fontSize = 18.sp,
                         fontWeight = FontWeight.Medium,
                         color = CharcoalGray
                     )
 
                     Icon(
                         imageVector = if (isSecondTrimesterExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                         contentDescription = if (isSecondTrimesterExpanded) "Collapse" else "Expand",
                         tint = CharcoalGray
                     )
                 }
             }
 
             // Dropdown content
             if (isSecondTrimesterExpanded) {
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
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Ebikyetaagibwa mu mmere ne calorie zikwata."
                             } else {
                                 "• Nutrient and calorie needs increase."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Weeyongere emmere ey'ebikula n'emu eyongera buli lunaku."
                             } else {
                                 "• Continue a varied diet and add one extra snack per day."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Emmere ennungi eziwera protein zikwatira ebijanjaalo, amagi, ennyanja (tilapia) oba ennyama, n'ensigo."
                             } else {
                                 "• Good protein sources include beans, eggs, fish (tilapia) or lean meat, and groundnuts."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Lya emmere eziwera ensawo (ennyama, liver, beans, amatunda amakulu) n'emmere eziwera vitamin C (mango, pawpaw, tomatoes) okusobozesa okukwatibwa."
                             } else {
                                 "• Eat iron-rich foods (meat, liver, beans, dark leafy greens) with vitamin C foods (mango, pawpaw, tomatoes) to boost absorption."
                             },
                             fontSize = 13.4.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Weeyongere okulya carbohydrates (maize, millet, rice, cassava, bananas) okufuna amaanyi."
                             } else {
                                 "• Keep eating carbohydrates (maize, millet, rice, cassava, bananas) for energy."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Nnywa amazzi amalungi era kola obulungi okuziyiza endwadde."
                             } else {
                                 "• Drink clean water and practice good hygiene to prevent illness."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
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
                         color = SoftPink,
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
                         text = if (languageManager.currentLanguage == "Luganda") "Emirundi gya Obukyala 7-9" else "Third trimester",
                         fontSize = 18.sp,
                         fontWeight = FontWeight.Medium,
                         color = CharcoalGray
                     )
 
                     Icon(
                         imageVector = if (isThirdTrimesterExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                         contentDescription = if (isThirdTrimesterExpanded) "Collapse" else "Expand",
                         tint = CharcoalGray
                     )
                 }
             }
 
             // Dropdown content
             if (isThirdTrimesterExpanded) {
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
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Weeyongere emmere eyongera."
                             } else {
                                 "• Continue the extra meal/snack."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Lya calcium (okukula kw'amagumba g'omwana) n'protein."
                             } else {
                                 "• Prioritize calcium (for baby's bone growth) and protein."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Emmere eziwera calcium zikwatira amata, amagi, ennyanja etono (n'amagumba), oba ebijanjaalo."
                             } else {
                                 "• Sources of calcium include milk, eggs, small fish (with bones), or beans."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Lekera emmere eziwera amafuta oba spicy eziyita heartburn era lya mpola."
                             } else {
                                 "• Avoid spicy or fatty foods that cause heartburn and eat slowly."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Lya emmere eziwera fiber (whole grains, fruits, vegetables) okuziyiza constipation."
                             } else {
                                 "• Include fiber-rich foods (whole grains, fruits, vegetables) to prevent constipation."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Weebula bulungi era weebale nga ogenda okwebaka nga okisobola okuleetawo obuzibu."
                             } else {
                                 "• Rest often and sleep propped up if needed to ease discomfort."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
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
                         color = SoftPink,
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
                         text = if (languageManager.currentLanguage == "Luganda") "Nga Omwana Azze (Okunyonya)" else "After Birth (Breastfeeding)",
                         fontSize = 18.sp,
                         fontWeight = FontWeight.Medium,
                         color = CharcoalGray
                     )
 
                     Icon(
                         imageVector = if (isAfterBirthExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                         contentDescription = if (isAfterBirthExpanded) "Collapse" else "Expand",
                         tint = CharcoalGray
                     )
                 }
             }
 
             // Dropdown content
             if (isAfterBirthExpanded) {
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
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Nga omwana azze, omukyala anyonya ayetaaga emmere bbiri eyongera buli lunaku."
                             } else {
                                 "• After birth, a breastfeeding mother needs about two extra snacks/meals per day."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Weeyongere okulya iron supplements (mu mirundi 3 nga omwana azze) era lya emmere eziwera vitamin A."
                             } else {
                                 "• Continue taking iron supplements (usually for 3 months after birth) and include vitamin A–rich foods or supplements."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Nnywa amazzi amangi (amazzi, soup, amata) okusobozesa okukula amata."
                             } else {
                                 "• Drink plenty of fluids (water, soup, milk) to support milk production."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                         Spacer(modifier = Modifier.height(8.dp))
                         Text(
                             text = if (languageManager.currentLanguage == "Luganda") {
                                 "• Omukyala aweebale bulungi era alye bulungi okufuna amaanyi."
                             } else {
                                 "• The mother should rest and eat well to regain strength."
                             },
                             fontSize = 14.sp,
                             color = CharcoalGray
                         )
                     }
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