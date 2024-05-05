package org.flyingrock

import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.theme.AppTheme

@Composable
@Preview
fun PreviewLoginPage() {
    AppTheme {
        LoginPage()

    }
}

@Composable
fun LoginPage() {
    val loginState by remember {
        mutableStateOf(LoginState(
            isPasswordError = false,
            isUserNameError = false,
        ))
    }
    Column (
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        LoginFields(loginState = loginState)
    }
}


data class LoginState(
    val isUserNameError: Boolean,
    val usernameSupportingText: String? = null,
    val isPasswordError: Boolean,
    val passwordSupportingText: String? = null,
)

@Composable
fun LoginFields(
    loginState: LoginState,
    onLoginClick: () -> Unit = {},
    onSignInClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
        ,
    ) {
        OutlinedTextField(
            value = "",
            isError = loginState.isUserNameError,
            label = {
                Text(text = "username")
            },
            supportingText = {
                loginState.usernameSupportingText?.let {
                    Text(text = it)
                }
            },
            onValueChange = {}
        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 20.dp),
            value = "",
            isError = loginState.isPasswordError,
            label = {
                Text(text = "password")
            },
            supportingText = {
                loginState.passwordSupportingText?.let {
                    Text(text = it)
                }
            },
            onValueChange = {}
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
