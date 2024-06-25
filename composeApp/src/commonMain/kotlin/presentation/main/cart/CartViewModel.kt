package presentation.main.cart

import androidx.compose.ui.graphics.Color
import core.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.CartModel
import kotlin.random.Random

class CartViewModel : ViewModel {
    private val _uiState = MutableStateFlow(CartState())
    val uiState: StateFlow<CartState> = _uiState.asStateFlow()

    init {
        cartList()
    }

    private fun cartList() {
        _uiState.update {
            it.copy(
                // Generate a list of URLs with random seeds
                cartList = List(20) {
                    CartModel(
                        image =
                        "https://picsum.photos/seed/${
                            Random.nextInt(
                                0,
                                20
                            )
                        }/1500/1500", "Nike", description = "description",
                        size = 1, color = generateRandomColor(),
                        price = Random.nextInt(
                            0,
                            1000
                        )
                    )
                }
            )
        }
    }

    /**
     * Removes an CartModel  from the list.
     * @param CartModel The CartModel  to be removed.
     */
    fun removeItem(currentItem: CartModel) {
        _uiState.update {
            val mutableList = it.cartList.toMutableList()
            mutableList.remove(currentItem)

            it.copy(
                cartList = mutableList
            )
        }
    }

}

data class CartState(
    val cartList: List<CartModel> = emptyList()
)

fun generateRandomColor(): Color {
    val r = Random.nextInt(256)
    val g = Random.nextInt(256)
    val b = Random.nextInt(256)
    return Color(r, g, b)
}