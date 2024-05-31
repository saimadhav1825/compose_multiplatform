package components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.compose_multiplatform
import composemultiplatformproject.composeapp.generated.resources.password_hide
import org.jetbrains.compose.resources.painterResource


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