package di


import org.koin.dsl.module
import presentation.country.CountryViewModel
import presentation.onboarding.OnBoardingViewModel

val viewModelModule = module {
    factory { CountryViewModel(get()) }
    factory { OnBoardingViewModel() }

}
