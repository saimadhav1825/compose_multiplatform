package presentation.fashionitem

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import components.KamelImageComponents
import core.viewModel

object FashionItemDetailScreen : Screen {

    @Composable
    override fun Content() {
        val fashionItemDetailViewModel: FashionItemDetailViewModel = viewModel()
        val uiState by fashionItemDetailViewModel.uiState.collectAsState()
        FashionItemDetailContent(uiState)

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FashionItemDetailContent(uiState: FashionDetailState) {
    val pageState = rememberPagerState(initialPage = 0) {
        uiState.imagesList.size
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            HorizontalPager(
                state = pageState,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            ) { page ->
                KamelImageComponents(
                    modifier = Modifier.fillMaxHeight(0.5f),
                    imageUrl = uiState.imagesList[page]
                )
            }
            Indicators(uiState.imagesList.size, pageState.currentPage)
        }

        Box {
            Column {

            }
        }

    }
}

@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)
    ) {
        repeat(size) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (it == index) MaterialTheme.colorScheme.onBackground
                        else MaterialTheme.colorScheme.surfaceDim
                    )
            )
        }
    }
}

