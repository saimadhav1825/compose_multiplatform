package di


import org.koin.dsl.module
import presentation.country.CountryViewModel
import presentation.fashionitem.FashionItemDetailViewModel
import presentation.main.cart.CartViewModel
import presentation.main.home.HomeViewModel
import presentation.main.notification.NotificationViewModel
import presentation.onboarding.OnBoardingViewModel

val viewModelModule = module {
    factory { CountryViewModel(get()) }
    factory { OnBoardingViewModel() }
    factory { HomeViewModel() }
    factory { CartViewModel() }
    factory { FashionItemDetailViewModel() }
    factory { NotificationViewModel() }

}
