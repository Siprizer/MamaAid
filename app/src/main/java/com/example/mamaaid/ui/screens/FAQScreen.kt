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

@Composable
fun FAQScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FAQ",
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
            Column {
                FAQItem(
                    question = "1. What foods should I eat during pregnancy?",
                    answer = "Eat healthy foods every day like leafy greens, beans, fruits, nuts, milk, meat or fish. Take folic acid and iron supplements from the clinic. Drink safe water and add one extra small meal or snack each day while pregnant."
                )
                Spacer(modifier = Modifier.height(16.dp))
                FAQItem(
                    question = "2. When and how often should I visit the clinic during pregnancy?",
                    answer = "Start clinic visits early, in the first 3 months. Go at least 4 times during pregnancy. The clinic checks your health, gives iron tablets, malaria pills, and vaccines to keep you and your baby safe."
                )
                Spacer(modifier = Modifier.height(16.dp))
                FAQItem(
                    question = "3. What warning signs should I watch for during pregnancy?",
                    answer = "Go to the clinic right away if you have heavy bleeding, severe headache, swelling, high fever, belly pain, or if the baby stops moving. These are danger signs and need urgent care."
                )
                Spacer(modifier = Modifier.height(16.dp))
                FAQItem(
                    question = "4. Which vaccines does my baby need in the first two years?",
                    answer = "Babies get vaccines at birth, 6, 10, and 14 weeks, and at 9 months. These protect against diseases like polio, tetanus, pneumonia, and measles. Vaccines help your child grow up strong and healthy."
                )
                Spacer(modifier = Modifier.height(16.dp))
                FAQItem(
                    question = "5. Are vaccines safe for my baby, and what side effects can happen?",
                    answer = "Yes, vaccines are safe. Some babies may get mild fever or a sore arm, but serious problems are very rare. Vaccines protect your child from deadly diseases, so don't skip any doses."
                )
            }
        }
        Text(
            text = "Maternal nutrition and immunization content adapted from WHO (CC BY‑NC‑SA 3.0 IGO) and the Uganda Ministry of Health. This app is strictly informational and does not provide medical prescriptions",
            fontSize = 8.5.sp,
            fontWeight = FontWeight.Thin,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
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
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = answer,
            fontSize = 14.sp,
            color = Color.Black,
            lineHeight = 20.sp
        )
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