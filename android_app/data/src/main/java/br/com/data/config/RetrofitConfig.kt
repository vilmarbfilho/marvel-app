package br.com.data.config

import br.com.data.service.MarvelService
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class RetrofitConfig {

    fun buildService() = Retrofit.Builder()
        .client(buildOkHttp())
        .baseUrl("http://gateway.marvel.com")
        .build()
        .create(MarvelService::class.java)

    private fun buildOkHttp() = OkHttpClient.Builder().build()

}