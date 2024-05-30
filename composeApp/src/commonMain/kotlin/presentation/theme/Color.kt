package presentation.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


val whiteColor = Color(color = 0xFFFFFFFF)
val blackColor = Color(color = 0xFF000000)
val light_gray = Color(color = 0xFFD3D3D3)


val lightColors = lightColorScheme(
    primary = whiteColor, secondary = blackColor,
    background = blackColor, surfaceDim = light_gray

)
val darkColors = darkColorScheme(
    primary = blackColor,
    onPrimary = blackColor,
    primaryContainer = blackColor,
    onPrimaryContainer = blackColor
)