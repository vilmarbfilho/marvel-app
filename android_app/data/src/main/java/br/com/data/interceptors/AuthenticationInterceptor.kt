package br.com.data.interceptors

import br.com.data.extensions.md5
import br.com.data.utils.getTimestamp
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(
    private val privateKey: String,
    private val publicKey: String
) : Interceptor {

    private val timestamp = getTimestamp().toString()

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url

        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", timestamp)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", generateHash())
            .build()

        val requestBuilder = originalRequest.newBuilder()
            .url(newUrl)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }

    private fun generateHash() = (timestamp + privateKey + publicKey)   .md5()

}