package presentation.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import components.KamelImageComponents
import components.WidthSpacer
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.profile
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.KeyValueModel
import org.jetbrains.compose.resources.stringResource
import presentation.profileedit.ProfileEditScreen

object ProfileScreenTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.profile)
            val icon = rememberVectorPainter(Icons.Default.Person)

            return remember {
                TabOptions(
                    index = 3u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val profileViewModel = viewModel {
            ProfileViewModel()
        }
        val state by profileViewModel.profileState.collectAsState()
        ProfileScreenContent(state)
    }
}

@Composable
fun ProfileScreenContent(state: ProfileState) {
    val navigator = LocalNavigator.currentOrThrow
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "App Icon",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Setting Icon",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.clickable {
                            navigator.parent?.push(ProfileEditScreen())
                        })
                }
            }
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor =
                        MaterialTheme.colorScheme.primary
                    ),
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                        KamelImageComponents(
                            modifier = Modifier.size(80.dp).clip(
                                shape = RoundedCornerShape(25.dp)
                            ),
                            imageUrl = "https://picsum.photos/id/237/200/300",
                            contentScale = ContentScale.FillBounds
                        )
                        WidthSpacer()
                        Column(verticalArrangement = Arrangement.Center) {
                            Text(
                                "Sai",
                                style = MaterialTheme.typography.headlineSmall
                            )
                            Text("sai@gmail.com", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .border(
                            2.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = MaterialTheme.shapes.extraLarge
                        ).padding(20.dp)
                ) {
                    state.firstList.forEach {
                        IconValue(it) {

                        }
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .border(
                            2.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = MaterialTheme.shapes.extraLarge
                        ).padding(20.dp)
                ) {
                    state.secondList.forEach {
                        IconValue(it) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun IconValue(item: KeyValueModel, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(50.dp)
                .background(
                    color = MaterialTheme.colorScheme.surfaceDim,
                    shape = MaterialTheme.shapes.medium
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = item.key, contentDescription = item.value)
        }

        Text(
            item.value,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.weight(1f).padding(horizontal = 10.dp)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "ArrowForward", modifier = Modifier.clickable {
                onItemClick.invoke()
            }
        )
    }
}