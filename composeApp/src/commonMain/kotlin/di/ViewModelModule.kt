package di


import org.koin.dsl.module
import presentation.country.CountryViewModel

val viewModelModule = module {
    factory { CountryViewModel(get()) }

}
