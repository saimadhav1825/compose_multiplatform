package presentation.country

import core.ViewModel
import core.viewModelScope
import data.CountryListResponseModel
import domain.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountryViewModel(
    private val repository: CountryRepository
) : ViewModel {
    private val _uiState = MutableStateFlow(CountryUiState())
    val uiState: StateFlow<CountryUiState> = _uiState

    init {
        getCountryList()
    }

    private fun getCountryList() {
        viewModelScope.launch {
            val artistDetailResult = repository.getCountryList()

            if (artistDetailResult.isSuccess) {
                _uiState.update { uiState ->
                    uiState.copy(
                        isLoading = false,
                        countryListResponseModel = artistDetailResult.getOrDefault(
                            CountryListResponseModel()
                        )
                    )
                }
            } else {
                _uiState.update { uiState ->
                    uiState.copy(isLoading = false, error = "Error!")
                }
            }
        }
    }

}