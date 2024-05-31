package components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource


@Composable
fun SocialSignButton(
    modifier: Modifier = Modifier,
    text: String,
    containColor: Color = MaterialTheme.colorScheme.onBackground,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = {
            onButtonClick.invoke()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = containColor
        ), modifier = Modifier.fillMaxWidth().then(
            modifier
        ).clip(shape = MaterialTheme.shapes.extraLarge), contentPadding = PaddingValues(20.dp)
    ) {
        Row {
            Icon(
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = "Social SignIn", modifier = Modifier.size(20.dp)
            )
            WidthSpacer()
            Text(text, color = textColor)
        }
    }
}