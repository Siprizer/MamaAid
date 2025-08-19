package com.example.mamaaid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mamaaid.data.LanguageManager
import com.example.mamaaid.navigation.BottomNavigation
import com.example.mamaaid.ui.screens.ChildScreen
import com.example.mamaaid.ui.screens.FAQScreen
import com.example.mamaaid.ui.screens.HomeScreen
import com.example.mamaaid.ui.screens.MotherScreen
import com.example.mamaaid.ui.theme.MamaAidTheme

class MainActivity : ComponentActivity() {
    private lateinit var languageManager: LanguageManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        languageManager = LanguageManager(this)
        enableEdgeToEdge()
        setContent {
            MamaAidTheme(dynamicColor = false) {
                MamaAidApp(languageManager = languageManager)
            }
        }
    }
}

@Composable
fun MamaAidApp(languageManager: LanguageManager) {
    val navController = rememberNavController()
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomNavigation(navController = navController, languageManager = languageManager)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(navController = navController, languageManager = languageManager)
            }
            composable("mother") {
                MotherScreen(languageManager = languageManager)
            }
            composable("child") {
                ChildScreen(languageManager = languageManager)
            }
            composable("faq") {
                FAQScreen(languageManager = languageManager)
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