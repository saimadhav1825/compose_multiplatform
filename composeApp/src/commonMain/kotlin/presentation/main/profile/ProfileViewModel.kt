package presentation.main.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.KeyValueModel

class ProfileViewModel : ScreenModel {
    private val _profileState = MutableStateFlow(ProfileState())
    val profileState: StateFlow<ProfileState> = _profileState.asStateFlow()

    init {
        _profileState.update {
            it.copy(
                firstList = mutableListOf(
                    KeyValueModel(key = Icons.Default.Person, value = "Profile Details"),
                    KeyValueModel(key = Icons.Default.Favorite, value = "My Order"),
                    KeyValueModel(key = Icons.Default.Favorite, value = "My Favourites"),
                    KeyValueModel(key = Icons.Default.Person, value = "Shipping Address"),
                    KeyValueModel(key = Icons.Default.ShoppingCart, value = "My Card"),
                    KeyValueModel(key = Icons.Default.Settings, value = "Settings")
                ), secondLsit = mutableListOf(
                    KeyValueModel(key = Icons.Default.Info, value = "FAQs"),
                    KeyValueModel(key = Icons.Default.Star, value = "Privacy Policy"),
                    KeyValueModel(key = Icons.Default.ThumbUp, value = "Terms and Conditions")
                )
            )
        }
    }
}

data class ProfileState(
    val firstList: List<KeyValueModel> = emptyList(),
    val secondLsit: List<KeyValueModel> = emptyList()
)