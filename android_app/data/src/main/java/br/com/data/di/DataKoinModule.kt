package br.com.data.di

import br.com.data.config.RetrofitConfig
import br.com.data.repository.HeroesRepositoryImpl
import br.com.marvelapp.repository.HeroesRepository
import org.koin.dsl.module

val dataKoinModule = module {

    single {
        RetrofitConfig().buildService()
    }

    factory<HeroesRepository> {
        HeroesRepositoryImpl(get())
    }
}