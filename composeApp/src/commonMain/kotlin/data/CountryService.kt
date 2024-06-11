package data

fun interface CountryService {
    suspend fun countryCapital(): CountryListResponseModel
}