package presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.KamelImageComponents
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.onboarding.OnBoardingScreen

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        SplashScreenContent()
        LaunchedEffect(Unit) {
            delay(1500L)
            navigator.push(OnBoardingScreen())
        }
    }
}

@Preview
@Composable
fun SplashScreenContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        KamelImageComponents(
            imageUrl = "https://picsum.photos/seed/100/1500/1500",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
    }
}