package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CountryServiceImpl(private val client: HttpClient,
): CountryService {

    override suspend fun countryCapital(): CountryListResponseModel {
        return client.get("capital").body()
    }

}