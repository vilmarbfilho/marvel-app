package br.com.data.config

import br.com.data.BuildConfig
import br.com.data.interceptors.AuthenticationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpConfig(
    private val authenticationInterceptor: AuthenticationInterceptor
) {

    // private val TIMEOUT = 15L

    fun buildClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()

        // builder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        // builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)

        builder.addInterceptor(authenticationInterceptor)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            builder.addInterceptor(loggingInterceptor)
        }

        return builder.build()
    }
}