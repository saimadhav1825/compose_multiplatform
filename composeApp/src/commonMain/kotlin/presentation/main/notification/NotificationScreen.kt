package presentation.main.notification

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.home
import org.jetbrains.compose.resources.stringResource

object NotificationScreenTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.home)
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {

    }
}