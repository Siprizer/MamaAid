package com.example.mamaaid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MamaAid title at the top
        Text(
            text = "MamaAid",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        
        // Dark gray underline with 0.3cm spacing
        Spacer(modifier = Modifier.height(12.dp)) // 0.3cm ≈ 12dp
        
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(2.dp)
                .background(Color.DarkGray)
        )
        
        // Subtitle with 1cm spacing from the line
        Spacer(modifier = Modifier.height(40.dp)) // 1cm ≈ 40dp
        
        Text(
            text = "Your pregnancy companion app",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        // Another 1cm spacing before the boxes
        Spacer(modifier = Modifier.height(40.dp)) // 1cm ≈ 40dp
        
        // Two square boxes with rounded corners
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Mother box
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(
                        color = Color(0xFFFFD1E3),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { navController.navigate("mother") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Mother",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            
            // Child box
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(
                        color = Color(0xFFFFD1E3),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { navController.navigate("child") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Child",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
} 