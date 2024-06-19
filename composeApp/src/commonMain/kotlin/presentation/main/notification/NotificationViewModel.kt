package presentation.main.notification

import core.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NotificationViewModel : ViewModel {
    private val _uiState = MutableStateFlow(NotificationState())
    val uiState: StateFlow<NotificationState> = _uiState.asStateFlow()

    init {
        getNotificationList()
    }

    private fun getNotificationList() {
        _uiState.update {
            it.copy(
                // Generate a list of URLs with random seeds
                notificationList = List(20) {
                    "https://picsum.photos/seed/${
                        Random.nextInt(
                            0,
                            20
                        )
                    }/1500/1500"
                }
            )
        }

    }

}

data class NotificationState(
    val notificationList: List<String> = emptyList()
)