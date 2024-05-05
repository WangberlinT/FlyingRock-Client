package component

import com.arkivanov.decompose.ComponentContext

class HomeScreenComponent(
    componentContext: ComponentContext,
    val onNavigateToLoginScreen: () -> Unit
) : CoroutineComponent(componentContext){

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.ItemClicked -> onNavigateToLoginScreen()
        }
    }

    sealed interface HomeScreenEvents {
        data object ItemClicked : HomeScreenEvents
    }
}