package components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var searchText by rememberSaveable { mutableStateOf("") }
    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.Black
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceDim,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceDim,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceDim,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp).clip(RoundedCornerShape(25.dp))
    )
}

@Preview
@Composable
fun CustomSearchBarPreview() {
    SearchBar()
}