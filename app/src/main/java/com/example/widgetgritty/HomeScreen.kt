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


@Composable
fun HomeScreen(onAppsClick: () -> Unit) {

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(all = 8.dp)
                .verticalScroll(state = rememberScrollState())
        ) {
            Card(
                onClick = { onAppsClick() },
                modifier = Modifier.padding(all = 20.dp)
                    .size(width = 200.dp, height = 200.dp),
                shape = RoundedCornerShape(size = 5.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Apps")


                }

            }

        }
        // SettingScreen(name = "Settings")
        // TODO: Figure out the button click for each bottomnavbar (HINT: onClick)

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
