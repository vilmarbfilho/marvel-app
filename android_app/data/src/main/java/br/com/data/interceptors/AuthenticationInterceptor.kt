package br.com.data.interceptors

import br.com.data.extensions.md5
import br.com.data.utils.getTimestamp
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(
    private val privateKey: String,
    private val publicKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url

        val timestamp = getTimestamp().toString()

        val hash = (timestamp + privateKey + publicKey).md5()

        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", timestamp)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()

        val requestBuilder = originalRequest.newBuilder()
            .url(newUrl)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }

}