package presentation.main.home

import model.FashionItemModel

data class HomeScreenState(
    val fashionList: List<SelectionOption> = emptyList(),
    val itemsList: List<FashionItemModel> = emptyList()
)