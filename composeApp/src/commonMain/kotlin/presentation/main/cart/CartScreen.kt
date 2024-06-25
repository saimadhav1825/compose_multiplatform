package presentation.main.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
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
import components.KamelImageComponents
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.cart
import core.viewModel
import org.jetbrains.compose.resources.stringResource

object CartScreenTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.cart)
            val icon = rememberVectorPainter(Icons.Default.ShoppingCart)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val cartViewModel: CartViewModel = viewModel()
        val uiState by cartViewModel.uiState.collectAsState()
        CartScreenContent(uiState)
    }
}

@Composable
fun CartScreenContent(uiState: CartState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "My Order",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(uiState.cartList) { item ->

                Row(modifier = Modifier.fillMaxWidth()) {
                    KamelImageComponents(
                        imageUrl = item.image,
                        modifier = Modifier.size(90.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Column(modifier = Modifier.weight(1f).padding(horizontal = 10.dp)) {
                        Text(
                            item.name,
                            style = MaterialTheme.typography.displayLarge
                        )
                        Text(
                            item.description,
                            style = MaterialTheme.typography.labelSmall,
                        )
                        Text(
                            "Size :${item.size}",
                            style = MaterialTheme.typography.labelSmall,
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "Color",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Box(
                                modifier = Modifier.padding(10.dp).size(10.dp).background(
                                    color = item.color,
                                    shape = CircleShape
                                )
                            )
                        }
                    }
                    Text(
                        "$ ${item.price.toDouble()}",
                        style = MaterialTheme.typography.displayLarge,
                        modifier = Modifier.padding(10.dp)
                    )
                }

            }
        }
    }
}