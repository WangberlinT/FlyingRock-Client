import androidx.compose.ui.window.ComposeUIViewController
import component.RootComponent

fun MainViewController(rootComponent: RootComponent) = ComposeUIViewController { App(rootComponent) }