package com.example.mamaaid.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mamaaid.ui.theme.BottomNavBackground
import kotlinx.coroutines.delay

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Apps
    )
    
    object Mother : BottomNavItem(
        route = "mother",
        title = "Mother",
        icon = Icons.Default.Person
    )
    
    object Child : BottomNavItem(
        route = "child",
        title = "Child",
        icon = Icons.Default.ChildCare
    )
    
    object FAQ : BottomNavItem(
        route = "faq",
        title = "FAQ",
        icon = Icons.Default.HelpOutline
    )
    /*
    object Contact : BottomNavItem(
        route = "contact",
        title = "Contact",
        icon = Icons.Default.LocalHospital
    )
    */

}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Mother,
    BottomNavItem.Child,
    BottomNavItem.FAQ
)

@Composable
fun BottomNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    var faqClickCount by remember { mutableStateOf(0) }
    var showPopup by remember { mutableStateOf(false) }
    
    // Reset FAQ click count after 3 seconds of inactivity
    LaunchedEffect(faqClickCount) {
        if (faqClickCount > 0) {
            delay(3000)
            faqClickCount = 0
        }
    }
    
    // Auto-hide popup after 3 seconds
    LaunchedEffect(showPopup) {
        if (showPopup) {
            delay(3000)
            showPopup = false
        }
    }
    
    Box {
        NavigationBar(
            containerColor = BottomNavBackground
        ) {
            bottomNavItems.forEach { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        if (item.route == "faq") {
                            faqClickCount++
                            if (faqClickCount >= 6) {
                                showPopup = true
                                faqClickCount = 0
                            }
                        }
                        
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationRoute!!) {
                                    saveState = false
                                }
                                launchSingleTop = true
                                restoreState = false
                            }
                        }
                    }
                )
            }
        }
        
        // Popup dialog
        if (showPopup) {
            Dialog(
                onDismissRequest = { showPopup = false },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFFAB7),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = "⏳Sherman — set the Wayback Machine to version 1.0⌛🌪️",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth()
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