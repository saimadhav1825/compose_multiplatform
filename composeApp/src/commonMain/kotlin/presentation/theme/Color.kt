package presentation.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


val whiteColor = Color(color = 0xFFFFFFFF)
val blackColor = Color(color = 0xFF000000)
val light_gray = Color(color = 0xFFD3D3D3)
val green_color = Color(0xff24A75E)
val platinum_color = Color(0xffE5E4E2)


val lightColors = lightColorScheme(
    primary = whiteColor, secondary = blackColor,
    background = whiteColor, surfaceDim = light_gray,
    outline = platinum_color, onBackground = blackColor
)