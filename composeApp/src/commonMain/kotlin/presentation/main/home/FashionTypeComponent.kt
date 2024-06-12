package presentation.main.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class SelectionOption(val option: String, private var initialSelectedValue: Boolean) {
    var selected by mutableStateOf(initialSelectedValue)
}

@Composable
fun FashionList(
    options: List<SelectionOption>, onOptionClicked: (SelectionOption) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(options) { option -> SingleSelectionCard(option, onOptionClicked) }
    }
}

@Composable
fun SingleSelectionCard(
    selectionOption: SelectionOption, onOptionClicked: (SelectionOption) -> Unit
) {
    Surface(
        modifier = Modifier.border(
            1.dp,
            if (selectionOption.selected) Color.Transparent else MaterialTheme.colorScheme.surfaceDim,
            RoundedCornerShape(20.dp)
        ).clickable(true, onClick = { onOptionClicked(selectionOption) }).clip(
            RoundedCornerShape(20.dp)
        ),
        color = if (selectionOption.selected)
            MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.primary,
    ) {
        Text(
            text = selectionOption.option,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
            color = if (selectionOption.selected)
                MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.secondary
        )
    }
}