package domain

import data.CountryListResponseModel

fun interface CountryRepository {
    suspend fun getCountryList(): Result<CountryListResponseModel>

}
