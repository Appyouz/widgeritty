package com.example.widgetgritty

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.widgetgritty.AppScreen
import com.example.widgetgritty.SettingScreen
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

@Composable
fun HomeScreen(onAppsClick: () -> Unit, onSettingClick: () -> Unit) {
    // val items = listOf("Apps", "Settings")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { TitleSection(name = "Home Screen") }
        item { YourWidgetSection(name = "Your widgets") }
    }

}


@Composable
fun TitleSection(name: String) {
    Text(text = name)
}

@Composable
fun YourWidgetSection(name: String) {
    Text(text = name)
}

@Preview
@Composable
fun PreviewTitleCard() {
    TitleSection("Widget")
}
