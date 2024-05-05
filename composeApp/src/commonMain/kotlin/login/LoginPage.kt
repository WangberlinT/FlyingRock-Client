package login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.LoginComponent

@Composable
fun LoginPage(component: LoginComponent) {
    val loginState by component.uiState.subscribeAsState()
    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter

    ) {
        LoginFields(
            loginState = loginState,
            onUsernameChange = component::onUsernameChange,
            onPasswordChange = component::onPasswordChange
        )
    }

}

data class LoginState(
    val isUserNameError: Boolean,
    val usernameText: String = "",
    val usernameSupportingText: String? = null,
    val isPasswordError: Boolean,
    val passwordText: String = "",
    val passwordSupportingText: String? = null,
)


@Composable
fun LoginFields(
    loginState: LoginState,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit = {},
    onSignInClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
        ,
    ) {
        OutlinedTextField(
            value = loginState.usernameText,
            isError = loginState.isUserNameError,
            label = {
                Text(text = "username")
            },
            supportingText = {
                loginState.usernameSupportingText?.let {
                    Text(text = it)
                }
            },
            onValueChange = onUsernameChange

        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 20.dp),
            value = loginState.passwordText,
            isError = loginState.isPasswordError,
            label = {
                Text(text = "password")
            },
            visualTransformation = PasswordVisualTransformation(),
            supportingText = {
                loginState.passwordSupportingText?.let {
                    Text(text = it)
                }
            },
            onValueChange = onPasswordChange
        )
        Row (
            modifier = Modifier
                .padding(top = 20.dp)
        ){
            Button(onClick = onLoginClick ) {
                Text(text = "Login")
            }
            Button(
                modifier = Modifier.padding(start = 20.dp),
                onClick = onSignInClick
            ) {
                Text(text = "Sign in")
            }
        }
    }
}
