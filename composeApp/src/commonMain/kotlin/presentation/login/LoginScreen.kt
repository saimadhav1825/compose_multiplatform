package presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        LoginScreenContent()
    }
}

@Preview
@Composable
fun LoginScreenContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Signup", color = MaterialTheme.colorScheme.onPrimary)
        Text("Create an New Account", color = MaterialTheme.colorScheme.secondary)

        Text("User Name", color = MaterialTheme.colorScheme.onPrimary)

    }
}
