package br.com.data.di

import br.com.data.config.OkHttpConfig
import br.com.data.config.RetrofitConfig
import br.com.data.interceptors.AuthenticationInterceptor
import br.com.data.repository.MarvelRepositoryImpl
import br.com.domain.constants.PRIVATE_KEY
import br.com.domain.constants.PUBLIC_KEY
import br.com.domain.repository.MarvelRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataKoinModule = module {

    single {
        RetrofitConfig(get()).buildService()
    }

    single {
        OkHttpConfig(get()).buildClient()
    }

    factory<MarvelRepository> {
        MarvelRepositoryImpl(get())
    }

    factory {
        AuthenticationInterceptor(
            privateKey = get(named(PRIVATE_KEY)),
            publicKey = get(named(PUBLIC_KEY))
        )
    }
}