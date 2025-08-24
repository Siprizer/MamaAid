package com.mamaaid.pregnancy.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mamaaid.pregnancy.data.LanguageManager
import com.mamaaid.pregnancy.ui.theme.WarmCream
import com.mamaaid.pregnancy.ui.theme.CharcoalGray
import com.mamaaid.pregnancy.ui.theme.SoftPink
import com.mamaaid.pregnancy.ui.theme.Typography
import kotlinx.coroutines.delay

sealed class BottomNavItem(
    val route: String,
    val titleKey: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        route = "home",
        titleKey = "home",
        icon = Icons.Default.Apps
    )
    
    object Mother : BottomNavItem(
        route = "mother",
        titleKey = "mother",
        icon = Icons.Default.Person
    )
    
    object Child : BottomNavItem(
        route = "child",
        titleKey = "child",
        icon = Icons.Default.ChildCare
    )
    
    object FAQ : BottomNavItem(
        route = "faq",
        titleKey = "faq",
        icon = Icons.Default.HelpOutline
    )
    /*
    object Contact : BottomNavItem(
        route = "contact",
        titleKey = "contact",
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
fun BottomNavigation(navController: NavController, languageManager: LanguageManager) {
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
            containerColor = WarmCream
        ) {
            bottomNavItems.forEach { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = languageManager.getTranslation(item.titleKey),
                            tint = CharcoalGray
                        )
                    },
                    label = {
                                            Text(
                        text = languageManager.getTranslation(item.titleKey),
                        style = Typography.labelSmall,
                        color = CharcoalGray
                    )
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
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = CharcoalGray,
                        selectedTextColor = CharcoalGray,
                        unselectedIconColor = CharcoalGray.copy(alpha = 0.6f),
                        unselectedTextColor = CharcoalGray.copy(alpha = 0.6f),
                        indicatorColor = SoftPink.copy(alpha = 0.3f)
                    )
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
                            color = WarmCream,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = "⏳Sherman — set the Wayback Machine to version 1.0⌛🌪️",
                        style = Typography.bodyLarge,
                        color = CharcoalGray,
                        modifier = Modifier.fillMaxWidth()
                    )
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