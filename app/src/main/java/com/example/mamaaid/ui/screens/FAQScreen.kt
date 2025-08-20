package com.example.mamaaid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mamaaid.data.LanguageManager
import com.example.mamaaid.ui.theme.BackgroundWithImage
import com.example.mamaaid.ui.theme.BabyBlue
import com.example.mamaaid.ui.theme.WarmCream
import com.example.mamaaid.ui.theme.CharcoalGray
import com.example.mamaaid.ui.theme.White
import com.example.mamaaid.ui.theme.Typography

@Composable
fun FAQScreen(languageManager: LanguageManager) {
    BackgroundWithImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // FAQ title in a curved corner box with Baby Blue background (matching home page)
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
                        text = languageManager.getTranslation("faq_title"),
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
                        color = WarmCream,
                        shape = RoundedCornerShape(8.dp),
                    )
                    .padding(16.dp)
            ) {
                Column {
                    FAQItem(
                        question = if (languageManager.currentLanguage == "Luganda") {
                            "1. Emmere ki gye ndya nga nkula omwana?"
                        } else {
                            "1. What foods should I eat during pregnancy?"
                        },
                        answer = if (languageManager.currentLanguage == "Luganda") {
                            "Lya emmere ennungi buli lunaku nk'amatunda, ebijanjaalo, amatunda, ensigo, amata, ennyama oba ennyanja. Lya folic acid n'iron supplements okuva ku kliniki. Nnywa amazzi amalungi era lya emmere emu eyongera buli lunaku nga ukula omwana."
                        } else {
                            "Eat healthy foods every day like leafy greens, beans, fruits, nuts, milk, meat or fish. Take folic acid and iron supplements from the clinic. Drink safe water and add one extra small meal or snack each day while pregnant."
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FAQItem(
                        question = if (languageManager.currentLanguage == "Luganda") {
                            "2. Ddi n'okukyalira emirundi ki nga nkula omwana?"
                        } else {
                            "2. When and how often should I visit the clinic during pregnancy?"
                        },
                        answer = if (languageManager.currentLanguage == "Luganda") {
                            "Tandika okukyalira kliniki ensolo, mu mirundi 3 egisooka. Genda okukyalira emirundi 4 nga ukula omwana. Kliniki ekyetoola obulamu bwo, ekuwa iron tablets, malaria pills, n'eddagala ly'okuziyiza okukulira ggwe n'omwana wo obulungi."
                        } else {
                            "Start clinic visits early, in the first 3 months. Go at least 4 times during pregnancy. The clinic checks your health, gives iron tablets, malaria pills, and vaccines to keep you and your baby safe."
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FAQItem(
                        question = if (languageManager.currentLanguage == "Luganda") {
                            "3. Ebimenyetso ki ebikyetaagibwa okulaba nga nkula omwana?"
                        } else {
                            "3. What warning signs should I watch for during pregnancy?"
                        },
                        answer = if (languageManager.currentLanguage == "Luganda") {
                            "Genda ku kliniki bwangu nga olina okukuba amazzi amangi, endwadde y'omutwe ennungi, okuzimba, endwadde ennungi, endwadde y'endya, oba nga omwana alekera okukyankalira. Bino bibi ebimenyetso ebikyetaagibwa obujjanjabi bw'ensolo."
                        } else {
                            "Go to the clinic right away if you have heavy bleeding, severe headache, swelling, high fever, belly pain, or if the baby stops moving. These are danger signs and need urgent care."
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FAQItem(
                        question = if (languageManager.currentLanguage == "Luganda") {
                            "4. Eddagala ki omwana wange ayetaaga mu myezi 2 egisooka?"
                        } else {
                            "4. Which vaccines does my baby need in the first two years?"
                        },
                        answer = if (languageManager.currentLanguage == "Luganda") {
                            "Abana bafuna eddagala nga bazze, mu mirundi 6, 10, n'14, n'emyezi 9. Bino biziyiza endwadde nk'polio, tetanus, pneumonia, n'measles. Eddagala lisobozesa omwana wo okukula nga mulamu n'amaanyi."
                        } else {
                            "Babies get vaccines at birth, 6, 10, and 14 weeks, and at 9 months. These protect against diseases like polio, tetanus, pneumonia, and measles. Vaccines help your child grow up strong and healthy."
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FAQItem(
                        question = if (languageManager.currentLanguage == "Luganda") {
                            "5. Eddagala limulungi ku mwana wange, n'ebiwuka ki ebiyoleka?"
                        } else {
                            "5. Are vaccines safe for my baby, and what side effects can happen?"
                        },
                        answer = if (languageManager.currentLanguage == "Luganda") {
                            "Yee, eddagala limulungi. Abana abamu basobola okufuna endwadde etono oba okulumwa omukono, naye ebizibu ebikulu biwuka. Eddagala liziyiza omwana wo ku ndwadde ezitta, kale toleka emirundi."
                        } else {
                            "Yes, vaccines are safe. Some babies may get mild fever or a sore arm, but serious problems are very rare. Vaccines protect your child from deadly diseases, so don't skip any doses."
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp)) // 0.2cm spacing

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
            ) {
                Text(
                    text = if (languageManager.currentLanguage == "Luganda") {
                        "Emmere y'obukyala n'eddagala ly'okuziyiza ebyawulibwa okuva ku WHO (CC BY‑NC‑SA 3.0 IGO) n'Minisitule y'Obulamu ya Uganda. Ekikulakulana kino kya bbeeyi naye tekikola eddagala."
                    } else {
                        "Maternal nutrition and immunization content adapted from WHO (CC BY‑NC‑SA 3.0 IGO) and the Uganda Ministry of Health. This app is strictly informational and does not provide medical prescriptions"
                    },
                    fontSize = 8.8.sp,
                    fontWeight = FontWeight.Thin,
                    color = CharcoalGray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun FAQItem(
    question: String,
    answer: String
) {
    Column {
        Text(
            text = question,
            style = Typography.titleMedium,
            color = CharcoalGray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = answer,
            style = Typography.bodyMedium,
            color = CharcoalGray
        )
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