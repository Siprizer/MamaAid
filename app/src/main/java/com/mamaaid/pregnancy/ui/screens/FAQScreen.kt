package com.mamaaid.pregnancy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import android.content.Intent
import android.net.Uri
import com.mamaaid.pregnancy.data.LanguageManager
import com.mamaaid.pregnancy.ui.theme.BackgroundWithImage
import com.mamaaid.pregnancy.ui.theme.BabyBlue
import com.mamaaid.pregnancy.ui.theme.WarmCream
import com.mamaaid.pregnancy.ui.theme.CharcoalGray
import com.mamaaid.pregnancy.ui.theme.White
import com.mamaaid.pregnancy.ui.theme.Typography

@Composable
fun FAQScreen(languageManager: LanguageManager) {
    var showPrivacyPolicy by remember { mutableStateOf(false) }
    val context = LocalContext.current
    
    BackgroundWithImage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // FAQ title with Baby Blue background (matching home page)
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
                        color = White,
                        textAlign = TextAlign.Center
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
                Column {
                    Text(
                        text = if (languageManager.currentLanguage == "Luganda") {
                            "Emmere y'obukyala n'eddagala ly'okuziyiza ebyawulibwa okuva ku WHO (CC BY‑NC‑SA 3.0 IGO) n'Minisitule y'Obulamu ya Uganda. Ekikulakulana kino kya bbeeyi naye tekikola eddagala.App enno tekirina nkolagana n'ekitongole ky'ebyobulamu eky'ensi yonna ekya World Health Organization ne minisitule y'ebyobulamu mu Uganda."
                        } else {
                            "Maternal nutrition and immunization content adapted from WHO (CC BY‑NC‑SA 3.0 IGO) and the Uganda Ministry of Health. This app is strictly informational and does not provide medical prescriptions. This app has no connections or affiliations with WHO and The Uganda Ministry of Health."
                        },
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = CharcoalGray,
                        textAlign = TextAlign.Center
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Privacy Policy",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = CharcoalGray,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showPrivacyPolicy = true }
                    )
                }
            }
        }
        
        // Privacy Policy Dialog
        if (showPrivacyPolicy) {
            PrivacyPolicyDialog(
                onDismiss = { showPrivacyPolicy = false },
                context = context
            )
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

@Composable
fun PrivacyPolicyDialog(
    onDismiss: () -> Unit,
    context: android.content.Context
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        // Dark gray blurred background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable { onDismiss() },
            contentAlignment = Alignment.Center
        ) {
            // Privacy Policy content box
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(
                        color = WarmCream,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
                    .clickable { /* Prevent click from propagating to background */ },
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Title
                    Text(
                        text = "Privacy Policy",
                        style = Typography.headlineMedium,
                        color = CharcoalGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    // Underline (0.5cm spacing) - centered
                    Spacer(modifier = Modifier.height(20.dp)) // 0.5cm ≈ 20dp
                    
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(2.dp)
                            .background(Color.DarkGray)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Privacy Policy content
                    Column {
                        // Effective Date
                        Text(
                            text = "Effective Date: 10/08/2025",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = CharcoalGray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Text(
                            text = "MamaAid (\"the App\") respects your privacy. This Privacy Policy explains how we handle information when you use our App.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Section 1
                        Text(
                            text = "1. Information We Collect",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "MamaAid does not collect or store any personal information such as names, email addresses, or medical records, and neither does it access or store any data from the users mobile device.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "This app uses analytics tools (such as Firebase Analytics) to collect anonymous usage statistics. This helps us understand how widely the app is used.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Section 2
                        Text(
                            text = "2. Use of Information",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "• To provide educational content on maternal and child health.\n• To improve the functionality and usability of the App.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Section 3
                        Text(
                            text = "3. Data Sharing",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "MamaAid does not sell, trade, or share user data with third parties.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "If any external content is provided (e.g., WHO or Uganda Ministry of Health guidelines), it is used under their respective licenses.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Section 4
                        Text(
                            text = "4. Children's Privacy",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "MamaAid is intended as a maternal and child health companion app. It does not knowingly collect personal information from children under 13.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Section 5
                        Text(
                            text = "5. Medical Disclaimer",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "MamaAid is for informational purposes only. It does not replace professional medical advice, diagnosis, or treatment. Always consult a qualified healthcare provider for medical concerns.",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Section 6
                        Text(
                            text = "6. Contact Us",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "If you have questions about this Privacy Policy, you may contact us at:",
                            style = Typography.bodyMedium,
                            color = CharcoalGray,
                            textAlign = TextAlign.Start
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "📧 ",
                                style = Typography.bodyMedium,
                                color = CharcoalGray
                            )
                            
                            // Clickable email
                            Text(
                                text = "cdevs25@outlook.com",
                                style = Typography.bodyMedium,
                                color = BabyBlue,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier.clickable {
                                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                                        data = Uri.parse("mailto:cdevs25@outlook.com")
                                    }
                                    context.startActivity(intent)
                                }
                            )
                        }
                        Spacer(modifier = Modifier.height(55.dp))
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