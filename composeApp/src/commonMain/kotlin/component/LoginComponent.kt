package component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import io.ktor.client.HttpClient
import login.LoginState

class LoginComponent(componentContext: ComponentContext) : CoroutineComponent(componentContext) {
    private val _uiState = MutableValue(LoginState(
        isPasswordError = false,
        isUserNameError = false
    ))
    val uiState: Value<LoginState> = _uiState


    fun onUsernameChange(text: String) {
        _uiState.value = _uiState.value.copy(usernameText = text)
    }

    fun onPasswordChange(text: String) {
        _uiState.value = _uiState.value.copy(passwordText = text)
    }

    fun onRegisterClick() {
        val username = _uiState.value.usernameText
        val password = _uiState.value.passwordText

        val client = HttpClient()

    }
}