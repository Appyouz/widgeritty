package com.example.widgetgritty

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable

import androidx.compose.ui.Modifier

enum class Destination(
    val icon: ImageVector,
)

@Serializable
data object HomeKey : NavKey

@Serializable
data object AppsKey : NavKey

@Serializable
data object SettingKey : NavKey

@Composable
fun MainScreen() {
    val backStack = remember { mutableStateListOf<Any>(HomeKey) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = backStack.last() == HomeKey,
                    onClick = {
                        // Remove everything except home key
                        backStack.removeAll { it != HomeKey }
                    },
                    icon = { },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = backStack.last() == AppsKey,
                    onClick = {
                        backStack.removeAll { it != HomeKey }
                        backStack.add(AppsKey)
                    },
                    icon = {
                    },
                    label = { Text("Apps") }
                )
                NavigationBarItem(
                    selected = backStack.last() == SettingKey,
                    onClick = {
                        backStack.removeAll { it != HomeKey }
                        backStack.add(SettingKey)
                    },
                    icon = { },
                    label = { Text("Settings") }
                )
            }
        }
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            onBack = {
                if (backStack.size > 1) backStack.removeLastOrNull()
            },
            entryProvider = { key ->
                when (key) {
                    is HomeKey -> NavEntry(key) {
                        HomeScreen(
                            onAppsClick = { backStack.add(AppsKey) },
                            onSettingClick = { backStack.add(SettingKey) }
                        )
                    }

                    is AppsKey -> NavEntry(key) { AppScreen(name = "Apps") }
                    is SettingKey -> NavEntry(key) { SettingScreen(name = "Settings") }
                    else -> error("Unknown key: $key")
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
