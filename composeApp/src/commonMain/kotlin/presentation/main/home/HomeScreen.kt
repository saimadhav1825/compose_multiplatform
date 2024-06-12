package presentation.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import components.HeightSpacer
import components.KamelImageComponents
import components.SearchBar
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.home
import core.viewModel
import org.jetbrains.compose.resources.stringResource
import presentation.fashionitem.FashionItemDetailScreen

object HomeScreenTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.home)
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val homeViewModel: HomeViewModel = viewModel()
        val uiState by homeViewModel.uiState.collectAsState()
        HomeScreenContent(uiState, homeViewModel::selectionOptionSelected)
    }
}

@Composable
fun HomeScreenContent(uiState: HomeScreenState, onOptionClicked: (SelectionOption) -> Unit) {
    val navigator = LocalNavigator.currentOrThrow
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            KamelImageComponents(
                imageUrl = "https://picsum.photos/seed/100/500/500",
                modifier = Modifier.padding(horizontal = 16.dp).size(40.dp).clip(CircleShape)
            )
        }
        HeightSpacer()
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        FashionList(options = uiState.fashionList, onOptionClicked)
        FashionItemList(uiState.itemsList) {
            navigator.parent?.push(FashionItemDetailScreen)
        }
    }

}