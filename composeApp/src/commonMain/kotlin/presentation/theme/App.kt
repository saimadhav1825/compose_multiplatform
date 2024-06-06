package presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.splash.SplashScreen


@Composable
@Preview
fun App() {
    val colors by mutableStateOf(lightColors)

    MaterialTheme(colorScheme = colors, typography = getTypography()) {
        Navigator(SplashScreen())
    }
}