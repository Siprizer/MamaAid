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
import com.example.mamaaid.navigation.BottomNavigation
import com.example.mamaaid.ui.screens.ChildScreen
import com.example.mamaaid.ui.screens.FAQScreen
import com.example.mamaaid.ui.screens.HomeScreen
import com.example.mamaaid.ui.screens.MotherScreen
import com.example.mamaaid.ui.theme.MamaAidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MamaAidTheme(dynamicColor = false) {
                MamaAidApp()
            }
        }
    }
}

@Composable
fun MamaAidApp() {
    val navController = rememberNavController()
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(navController = navController)
            }
            composable("mother") {
                MotherScreen()
            }
            composable("child") {
                ChildScreen()
            }
            composable("faq") {
                FAQScreen()
            }
        }
    }
}