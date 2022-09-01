package br.com.data.config

import br.com.data.interceptors.AuthenticationInterceptor
import okhttp3.OkHttpClient

class OkHttpConfig(
    private val authenticationInterceptor: AuthenticationInterceptor
) {

    // private val TIMEOUT = 15L

    fun buildClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()

        // builder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        // builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)

        builder.addInterceptor(authenticationInterceptor)

        return builder.build()
    }
}