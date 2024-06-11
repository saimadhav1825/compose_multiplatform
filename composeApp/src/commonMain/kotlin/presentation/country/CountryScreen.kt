package presentation.country

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import core.viewModel

class CountryScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: CountryViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsState()
        CountryScreenContent(uiState)
    }
}

@Composable
fun CountryScreenContent(uiState: CountryUiState) {
    LazyColumn {
        items(uiState.countryListResponseModel.data) {
            Text(it.capital.toString())
        }
    }
}