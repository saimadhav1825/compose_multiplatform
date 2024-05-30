package presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import components.CustomNormalButton
import components.HeightSpacer
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.compose_multiplatform
import composemultiplatformproject.composeapp.generated.resources.password_hide
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

class SignupScreen : Screen {
    @Composable
    override fun Content() {
        SignupScreenContent()
    }
}

@Preview
@Composable
fun SignupScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = "App Icon", modifier = Modifier.size(100.dp)
                )
            }
            HeightSpacer(50.dp)

            Text(
                "Signup",
                style = MaterialTheme.typography.headlineSmall
            )
            Text("Create an New Account", style = MaterialTheme.typography.labelSmall)

            HeightSpacer(50.dp)
            Text("User Name", style = MaterialTheme.typography.headlineSmall)
            CustomTextFiledInputComponent(textValue = "") {

            }
            HeightSpacer()
            Text("Email", style = MaterialTheme.typography.headlineSmall)
            CustomTextFiledInputComponent(textValue = "") {

            }
            HeightSpacer()
            Text("Password", style = MaterialTheme.typography.headlineSmall)
            CustomPasswordFiledInputComponent(textValue = "") {

            }
            HeightSpacer()
            Text("Confirm Password", style = MaterialTheme.typography.headlineSmall)
            CustomPasswordFiledInputComponent(textValue = "") {

            }

            HeightSpacer()
            TermAndCondition()
            HeightSpacer()
            CustomNormalButton(
                text = "Login",
                containColor = MaterialTheme.colorScheme.background,
                textColor = MaterialTheme.colorScheme.primary
            ) {

            }
            HeightSpacer(20.dp)
        }

    }
}

@Composable
fun CustomTextFiledInputComponent(
    modifier: Modifier = Modifier,
    textValue: String,
    onTextChanged: (String) -> Unit,
) {
    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(text = textValue))
    }
    TextField(
        value = textFieldValue,
        onValueChange = { newValue ->
            textFieldValue = newValue
            onTextChanged(newValue.text)
        }, colors = TextFieldDefaults.colors(
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ), modifier = Modifier.fillMaxWidth().then(modifier)
    )
}

@Composable
fun CustomPasswordFiledInputComponent(
    modifier: Modifier = Modifier,
    textValue: String,
    onTextChanged: (String) -> Unit,
) {
    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(text = textValue))
    }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    TextField(
        value = textFieldValue,
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = if (passwordVisibility)
                painterResource(Res.drawable.password_hide)
            else
                painterResource(Res.drawable.compose_multiplatform)
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon"
                )
            }

        },
        onValueChange = {
            textFieldValue = it

        }, colors = TextFieldDefaults.colors(
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ), modifier = Modifier.fillMaxWidth().then(modifier)
    )
}

@Composable
fun TermAndCondition(modifier: Modifier = Modifier) {
    // in below line we are setting
    // the state of our checkbox.
    var checkedState by remember { mutableStateOf(false) }
    // in below line we are displaying a row
    // and we are creating a checkbox in a row.
    Row(
        modifier = Modifier.fillMaxWidth().then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            // below line we are setting
            // the state of checkbox.
            checked = checkedState,
            // below line is use to add padding
            // to our checkbox.
            modifier = Modifier,
            // below line is use to add on check
            // change to our checkbox.
            onCheckedChange = { checkedState = it },
        )
        // below line is use to add text to our check box and we are
        // adding padding to our text of checkbox
        Text(
            text = "By Creating An Account you have to agree with our term & condition",
            style = MaterialTheme.typography.labelSmall
        )
    }
}
