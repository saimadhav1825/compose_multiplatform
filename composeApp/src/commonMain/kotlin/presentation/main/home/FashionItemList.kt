package presentation.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import components.HeightSpacer
import components.KamelImageComponents
import model.FashionItemModel

@Composable
fun FashionItemList(itemsList: List<FashionItemModel>, onItemNavigate: (String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(itemsList) {
            Box {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    KamelImageComponents(
                        imageUrl = it.image.toString(),
                        modifier = Modifier.fillMaxWidth().height(200.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { onItemNavigate.invoke("") },
                        contentScale = ContentScale.FillBounds
                    )
                    HeightSpacer()
                    Text(it.name.toString(), style = MaterialTheme.typography.headlineSmall)
                    Text(it.model.toString(), style = MaterialTheme.typography.labelSmall)
                    Text(it.price.toString(), style = MaterialTheme.typography.headlineSmall)
                }
                Box(
                    modifier = Modifier.padding(10.dp).size(20.dp)
                        .background(
                            color = MaterialTheme.colorScheme.secondary,
                            shape = CircleShape
                        )
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Favorite Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

        }

    }

}