package presentation.registrationsuccess

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.CustomNormalButton
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.done
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.main.MainScreen
import presentation.theme.green_color

class RegistrationSuccessFullScreen : Screen {
    @Composable
    override fun Content() {
        RegistrationSuccessFullContent()
    }
}

@Preview
@Composable
fun RegistrationSuccessFullContent() {
    val navigator = LocalNavigator.currentOrThrow
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxHeight(0.8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.size(60.dp)
                        .border(2.dp, color = green_color, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.done),
                        contentDescription = "Social SignIn",
                        modifier = Modifier.size(30.dp),
                        tint = green_color
                    )
                }

                Text(
                    "Successful!",
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    "You Have Successfully registered in our app and start working on it",
                    style = MaterialTheme.typography.labelSmall, textAlign = TextAlign.Center
                )
            }

        }
        Column {
            CustomNormalButton(
                text = "Start Shopping",
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                navigator.push(MainScreen())
            }
        }
    }
}