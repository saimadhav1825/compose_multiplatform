package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TermAndCondition(modifier: Modifier = Modifier) {
    // in below line we are setting
    // the state of our checkbox.
    var checkedState by remember { mutableStateOf(false) }
    // in below line we are displaying a row
    // and we are creating a checkbox in a row.
    Row(
        modifier = Modifier.fillMaxWidth().then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            // below line we are setting
            // the state of checkbox.
            checked = checkedState,
            // below line is use to add padding
            // to our checkbox.
            modifier = Modifier,
            // below line is use to add on check
            // change to our checkbox.
            onCheckedChange = { checkedState = it },
        )
        // below line is use to add text to our check box and we are
        // adding padding to our text of checkbox
        Text(
            text = "By Creating An Account you have to agree with our term & condition",
            style = MaterialTheme.typography.labelSmall
        )
    }
}