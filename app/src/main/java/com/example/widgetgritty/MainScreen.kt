package com.example.widgetgritty

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.example.widgetgritty.AppScreen
import com.example.widgetgritty.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeKey : NavKey

@Serializable
data object AppsKey : NavKey

@Composable
fun MainScreen() {
    val backStack = remember { mutableStateListOf<Any>(HomeKey) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is HomeKey -> NavEntry(key) {
                    HomeScreen(onAppsClick = { backStack.add(AppsKey) })
                }

                is AppsKey -> NavEntry(key) {
                    AppScreen(name = "Apps")
                }

                else -> error("Unknown key: $key")
            }
        }
    )
}

