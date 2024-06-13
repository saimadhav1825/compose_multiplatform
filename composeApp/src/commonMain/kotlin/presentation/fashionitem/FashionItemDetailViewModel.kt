package presentation.fashionitem

import core.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FashionItemDetailViewModel : ViewModel {
    private val _uiState = MutableStateFlow(FashionDetailState())
    val uiState: StateFlow<FashionDetailState> = _uiState.asStateFlow()

    init {
       getImagesList()
    }

    private fun getImagesList() {
        _uiState.update {
            it.copy(
                imagesList = mutableListOf(
                    "https://picsum.photos/seed/200/1500/1500",
                    "https://picsum.photos/seed/201/1500/1500",
                    "https://picsum.photos/seed/202/1500/1500"
                )
            )
        }
    }

}

data class FashionDetailState(
    val imagesList: List<String> = emptyList()
)