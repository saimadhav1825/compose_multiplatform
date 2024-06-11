package presentation.onboarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import components.KamelImageComponents
import core.viewModel
import kotlinx.coroutines.launch
import model.OnBoardingModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.graphicsLayer
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.login.LoginScreen

class OnBoardingScreen : Screen {
    @Composable
    override fun Content() {
        val onBoardingViewModel: OnBoardingViewModel = viewModel()
        val onBoardingState by onBoardingViewModel.uiState.collectAsState()
        OnBoardingContent(onBoardingState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun OnBoardingContent(onBoardingState: OnBoardingState) {
    val navigator= LocalNavigator.currentOrThrow
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState(initialPage = 0) {
        onBoardingState.list.size
    }

    Column(modifier = Modifier.fillMaxSize()) {

        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
        ) { page ->
            OnBoardingItem(item = onBoardingState.list[page])
        }
        BottomSection(size = onBoardingState.list.size, index = pageState.currentPage) {
            if (pageState.currentPage + 1 < onBoardingState.list.size) scope.launch {
                pageState.scrollToPage(pageState.currentPage + 1)
            } else {
                navigator.push(LoginScreen())
            }
        }
    }
}

@Composable
fun BottomSection(size: Int, index: Int, onButtonClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        // Indicators
        Indicators(size, index)

        FloatingActionButton(
            onClick = { onButtonClick.invoke() },
            containerColor = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
        ) {
            Icon(
                Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                tint = Color.White,
                contentDescription = "Localized description"
            )
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
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 20.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
    )

    Box(
        modifier = Modifier
            .height(5.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.surfaceDim
            )
    ) {

    }
}

@Composable
fun OnBoardingItem(item: OnBoardingModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp)
    ) {
        KamelImageComponents(
            imageUrl = item.image, contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxHeight(0.7f)
                .fillMaxWidth().graphicsLayer(
                    rotationZ = { fraction: Float ->
                        45f * fraction
                    }
                ).clip(RoundedCornerShape(20.dp))
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.desc,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

// Extension function to create a graphics layer with varying rotation
fun Modifier.graphicsLayer(rotationZ: (Float) -> Float): Modifier {
    return this.then(
        Modifier.graphicsLayer {
            val fraction = size.height / size.width
            rotationZ(rotationZ(fraction))
        }
    )
}