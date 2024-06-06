package presentation.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.CustomNormalButton
import components.OutlinedCustomButton
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.login
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.login.LoginScreen
import presentation.signup.SignupScreen

class WelcomeScreen : Screen {
    @Composable
    override fun Content() {
        WelcomeScreenContent()
    }
}

@Preview
@Composable
fun WelcomeScreenContent() {
    val navigator = LocalNavigator.currentOrThrow
    Box(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            CustomNormalButton(
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
                ),
                text = stringResource(Res.string.login),
                containColor = MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.onBackground
            ) {
                navigator.push(LoginScreen())
            }
            OutlinedCustomButton(
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
                ), text = "Sign Up"
            ) {
                navigator.push(SignupScreen())
            }
        }
    }
}

