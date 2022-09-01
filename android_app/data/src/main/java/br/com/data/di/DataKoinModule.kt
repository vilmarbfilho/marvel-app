package br.com.data.di

import br.com.data.config.RetrofitConfig
import br.com.data.repository.MarvelRepositoryImpl
import br.com.domain.repository.MarvelRepository
import org.koin.dsl.module

val dataKoinModule = module {

    single {
        RetrofitConfig().buildService()
    }

    factory<MarvelRepository> {
        MarvelRepositoryImpl(get())
    }
}