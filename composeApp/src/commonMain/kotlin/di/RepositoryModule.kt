package di


import data.CountryRepositoryImpl
import domain.CountryRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CountryRepository> { CountryRepositoryImpl(get()) }

}
