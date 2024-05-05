package component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.*

class RootComponent(
    val componentContext: ComponentContext
) : ComponentContext by componentContext {

    val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.HomeScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )


    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ) = when (config) {
        is Configuration.LoginScreen -> Child.LoginScreen(
            LoginComponent(
                componentContext = context,
            )
        )

        Configuration.HomeScreen -> Child.HomeScreen(
            HomeScreenComponent(
                componentContext = context,
                onNavigateToLoginScreen = {
                    navigation.pushNew(Configuration.LoginScreen)
                }
            )
        )
    }

}

sealed class Child {
    data class HomeScreen(val component: HomeScreenComponent) : Child()
    data class LoginScreen(val component: LoginComponent) : Child()
}

@Serializable
sealed interface Configuration {
    @Serializable
    data object HomeScreen : Configuration

    @Serializable
    data object LoginScreen : Configuration
}
