import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.Child
import component.RootComponent
import org.jetbrains.compose.ui.tooling.preview.Preview

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import login.LoginPage
import ui.theme.AppTheme
import view.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App(root: RootComponent) {
    val childStack by root.childStack.subscribeAsState()
    AppTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Flying Rock") },
                )
            },
        ) {
            Children(
                modifier = Modifier.padding(it),
                stack = childStack,
                animation = stackAnimation(slide())
            ) { child ->
                when (val instance = child.instance) {
                    is Child.LoginScreen -> LoginPage(instance.component)
                    is Child.HomeScreen -> HomeScreen(instance.component)
                }
            }
        }
    }
}