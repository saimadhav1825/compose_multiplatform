package data


import domain.CountryRepository
import utils.resultOf

class CountryRepositoryImpl(
    private val service: CountryService,
) : CountryRepository {
    override suspend fun getCountryList(): Result<CountryListResponseModel> {
        return resultOf {
            service.countryCapital()
        }
    }


}

