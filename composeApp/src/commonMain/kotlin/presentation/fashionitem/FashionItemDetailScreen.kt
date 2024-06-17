package presentation.fashionitem

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.KamelImageComponents
import components.StarRatingBar
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
    val navigator = LocalNavigator.currentOrThrow
    val pageState = rememberPagerState(initialPage = 0) {
        uiState.imagesList.size
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                HorizontalPager(
                    state = pageState,
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    KamelImageComponents(
                        modifier = Modifier.fillMaxHeight(),
                        imageUrl = uiState.imagesList[page], contentScale = ContentScale.FillBounds
                    )
                }
                Box(modifier = Modifier.align(Alignment.TopStart).padding(20.dp)) {
                    IconButton(onClick = {
                        navigator.pop()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Icon"
                        )
                    }
                }
                Box(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp)) {
                    Indicators(uiState.imagesList.size, pageState.currentPage)
                }
                Box(
                    modifier = Modifier.align(Alignment.BottomEnd).padding(20.dp)
                        .background(color = Color.White, shape = CircleShape).size(25.dp)
                        .padding(3.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        tint = Color.Black,
                        contentDescription = "Favourite"
                    )
                }
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

