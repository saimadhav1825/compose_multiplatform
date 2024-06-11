package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CountryModel(
    @SerialName("name") var name: String? = null,
    @SerialName("capital") var capital: String? = null,
    @SerialName("iso2") var iso2: String? = null,
    @SerialName("iso3") var iso3: String? = null
)