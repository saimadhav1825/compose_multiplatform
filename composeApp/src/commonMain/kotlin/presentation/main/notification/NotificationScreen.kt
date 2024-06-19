package presentation.main.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import components.HeightSpacer
import components.KamelImageComponents
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.notifications
import core.viewModel
import org.jetbrains.compose.resources.stringResource

object NotificationScreenTab : Tab {

    override val options: TabOptions
        @Composable get() {
            val title = stringResource(Res.string.notifications)
            val icon = rememberVectorPainter(Icons.Default.Notifications)

            return remember {
                TabOptions(
                    index = 2u, title = title, icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val notificationViewModel: NotificationViewModel = viewModel()
        val uiState by notificationViewModel.uiState.collectAsState()
        NotificationScreenContent(uiState)
    }
}

@Composable
fun NotificationScreenContent(uiState: NotificationState) {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            "Notification",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(uiState.notificationList) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    KamelImageComponents(
                        modifier = Modifier.size(80.dp).clip(
                            shape = CircleShape
                        ), imageUrl = it, contentScale = ContentScale.FillBounds
                    )
                    Text("Hi ", modifier = Modifier.padding(10.dp))
                }
                HeightSpacer()
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surfaceDim
                )
            }

        }

    }

}