package presentation.country

import data.CountryListResponseModel

data class CountryUiState(
    val isLoading: Boolean = true,
    val countryListResponseModel: CountryListResponseModel = CountryListResponseModel(),
    val error: String? = null
)