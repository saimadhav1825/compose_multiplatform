package presentation.profileedit

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.KeyValueModel



class ProfileEditViewModel : ViewModel() {
    private val _profileEditState = MutableStateFlow(ProfileEditState())
    val profileEditState: StateFlow<ProfileEditState> = _profileEditState.asStateFlow()

    init {
        _profileEditState.update {
            it.copy(
                settingList = mutableListOf(
                    KeyValueModel(key = Icons.Default.MailOutline, value = "Language"),
                    KeyValueModel(key = Icons.Default.Notifications, value = "My Order"),
                    KeyValueModel(key = Icons.Default.MoreVert, value = "Dark Mood"),
                    KeyValueModel(key = Icons.Default.ShoppingCart, value = "Help Center")
                )
            )
        }
    }
}

data class ProfileEditState(
    val settingList: List<KeyValueModel> = emptyList()
)
