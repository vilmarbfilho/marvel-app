package br.com.data.config

import br.com.data.service.MarvelService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitConfig(
    private val httpClient: OkHttpClient
) {

    fun buildService() = Retrofit.Builder()
        .client(httpClient)
        .baseUrl("http://gateway.marvel.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(MarvelService::class.java)

}