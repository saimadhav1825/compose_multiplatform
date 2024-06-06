package components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun CustomNormalButton(
    modifier: Modifier = Modifier,
    text: String,
    containColor: Color = MaterialTheme.colorScheme.onBackground,
    textColor: Color = MaterialTheme.colorScheme.primary,
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
        Text(text, color = textColor)
    }
}


@Composable
fun OutlinedCustomButton(modifier: Modifier = Modifier, text: String, onButtonClick: () -> Unit) {
    Button(
        onClick = {
            onButtonClick.invoke()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth().then(
            modifier
        ).border(
            2.dp,
            color = MaterialTheme.colorScheme.background,
            shape = MaterialTheme.shapes.extraLarge
        ), contentPadding = PaddingValues(20.dp)
    ) {
        Text(text = text, color = MaterialTheme.colorScheme.background)
    }
}
