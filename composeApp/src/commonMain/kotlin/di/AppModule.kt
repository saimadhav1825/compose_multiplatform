package di

import org.koin.core.KoinApplication
import org.koin.core.module.Module

fun KoinApplication.init() {
    modules(networkModule, repositoryModule, useCaseModule, viewModelModule)
}