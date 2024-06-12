package presentation.fashionitem

import core.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FashionItemDetailViewModel : ViewModel {
    private val _uiState = MutableStateFlow(FashionDetailState())
    val uiState: StateFlow<FashionDetailState> = _uiState

}

data class FashionDetailState(
    val imagesList: List<String> = emptyList()
)