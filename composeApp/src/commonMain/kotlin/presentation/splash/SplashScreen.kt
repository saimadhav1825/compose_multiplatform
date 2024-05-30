package presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.welcome.WelcomeScreen

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(Unit) {
            delay(500)
            navigator.push(WelcomeScreen())
        }
        SplashScreenContent()
    }
}

@Preview
@Composable
fun SplashScreenContent() {
    Column(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {

    }
}