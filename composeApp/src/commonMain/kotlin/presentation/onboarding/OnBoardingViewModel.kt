package presentation.onboarding

import core.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import model.OnBoardingModel
import presentation.country.CountryUiState

class OnBoardingViewModel : ViewModel {
    private val _uiState = MutableStateFlow(OnBoardingState())
    val uiState: StateFlow<OnBoardingState> = _uiState

    init {
        onBoardingList()
    }

    private fun onBoardingList() {
        _uiState.update {
            it.copy(
                list = listOf(
                    OnBoardingModel(
                        "https://picsum.photos/seed/101/1000/1000",
                        "20 % Discount New Arrival Product",
                        "Publish up your selfies to make yourself more beautiful with the app"
                    ),
                    OnBoardingModel(
                        "https://picsum.photos/seed/102/1000/1000",
                        "Take Advantage of the offer shopping",
                        "Publish up your selfies to make yourself more beautiful with the app"
                    ),
                    OnBoardingModel(
                        "https://picsum.photos/seed/103/1000/1000",
                        "All Type  Offers Within Your Reach",
                        "Publish up your selfies to make yourself more beautiful with the app"
                    )
                )
            )
        }
    }
}