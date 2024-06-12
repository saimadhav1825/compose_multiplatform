package presentation.main.home

import core.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import model.FashionItemModel

class HomeViewModel : ViewModel {
    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState

    init {
        fashionTypeList()
        fashionItemsList()
    }

    private fun fashionTypeList() {
        _uiState.update {
            it.copy(
                fashionList = mutableListOf(
                    SelectionOption("Dresses", false),
                    SelectionOption("Jackets", false),
                    SelectionOption("Jeans", false),
                    SelectionOption("Shoes", false),
                    SelectionOption("Bags", false)
                )
            )
        }
    }

    fun selectionOptionSelected(selectedOption: SelectionOption) {
        _uiState.value.fashionList.forEach { it.selected = false }
        _uiState.value.fashionList.find { it.option == selectedOption.option }?.selected = true
    }

    private fun fashionItemsList() {
        _uiState.update {
            val newList = mutableListOf<FashionItemModel>()
            for (i in 1..50) {
                newList.add(
                    FashionItemModel(
                        image = "https://picsum.photos/seed/${100 + i}/1000/1000",
                        name = "Item $i",
                        model = "Nike",
                        price = "$100.00"
                    )
                )
            }
            it.copy(itemsList = newList)
        }
    }
}