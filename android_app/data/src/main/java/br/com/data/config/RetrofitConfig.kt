package br.com.data.config

import br.com.data.service.MarvelService
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class RetrofitConfig(
    private val httpClient: OkHttpClient
) {

    fun buildService() = Retrofit.Builder()
        .client(httpClient)
        .baseUrl("http://gateway.marvel.com")
        .build()
        .create(MarvelService::class.java)

}