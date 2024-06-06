package presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.CustomNormalButton
import components.CustomPasswordFiledInputComponent
import components.CustomTextFiledInputComponent
import components.HeightSpacer
import components.SocialSignButton
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.registrationsuccess.RegistrationSuccessFullScreen

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        LoginScreenContent()
    }
}

@Preview
@Composable
fun LoginScreenContent() {
    val navigator = LocalNavigator.currentOrThrow
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = "App Icon", modifier = Modifier.size(100.dp)
                )
            }
            HeightSpacer(50.dp)

            Text(
                "Welcome!",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                "Please login or signup to continue our app",
                style = MaterialTheme.typography.labelSmall
            )
            HeightSpacer(30.dp)
            Text("Email", style = MaterialTheme.typography.headlineSmall)
            CustomTextFiledInputComponent(textValue = "") {

            }
            HeightSpacer()
            Text("Password", style = MaterialTheme.typography.headlineSmall)
            CustomPasswordFiledInputComponent(textValue = "") {

            }

            HeightSpacer(20.dp)
            CustomNormalButton(
                text = "Login"
            ) {
                navigator.push(RegistrationSuccessFullScreen())
            }
            HeightSpacer(20.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.fillMaxWidth(0.45f))
                Text("or", modifier = Modifier.padding(horizontal = 10.dp))
                HorizontalDivider(modifier = Modifier.fillMaxWidth())
            }
            SocialSignButton(text = "Continue With FaceBook") {

            }
            HeightSpacer()
            SocialSignButton(text = "Continue With Google") {

            }
            HeightSpacer()
            SocialSignButton(text = "Continue With Apple") {

            }
        }
    }
}
