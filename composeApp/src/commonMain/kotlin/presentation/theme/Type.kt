package presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.poppins_bold
import composemultiplatformproject.composeapp.generated.resources.poppins_light
import composemultiplatformproject.composeapp.generated.resources.poppins_medium
import composemultiplatformproject.composeapp.generated.resources.poppins_regular
import composemultiplatformproject.composeapp.generated.resources.poppins_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun getTypography(): Typography {
    val poppins = FontFamily(
        Font(Res.font.poppins_light, weight = FontWeight.Light),
        Font(Res.font.poppins_regular, weight = FontWeight.Normal),
        Font(Res.font.poppins_medium, weight = FontWeight.Medium),
        Font(Res.font.poppins_semibold, weight = FontWeight.SemiBold),
        Font(Res.font.poppins_bold, weight = FontWeight.Bold)
    )
    return Typography(
        headlineSmall = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Black
        ),
        labelSmall = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = light_gray
        ),
        displayLarge = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        ),
    )
}

