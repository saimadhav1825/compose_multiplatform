package components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun KamelImageComponents(
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    imageUrl: String
) {
    KamelImage(
        asyncPainterResource(imageUrl),
        contentDescription = "Compose",
        modifier = modifier, contentScale = contentScale,
        onFailure = {})
}