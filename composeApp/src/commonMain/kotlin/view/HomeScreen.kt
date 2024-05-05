package view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import component.Child
import component.HomeScreenComponent


@Composable
fun HomeScreen(component: HomeScreenComponent) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Button(
            onClick = {
                component.onEvent(HomeScreenComponent.HomeScreenEvents.ItemClicked)
            }
        ) {
            Text(text = "go to login")
        }
    }
}