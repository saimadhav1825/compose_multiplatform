package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryListResponseModel(
    @SerialName("error") var error: Boolean? = null,
    @SerialName("msg") var msg: String? = null,
    @SerialName("data") var data: ArrayList<CountryModel> = arrayListOf()
)