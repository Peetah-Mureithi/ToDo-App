package com.techmashinani.filamu.api

import com.techmashinani.filamu.BuildConfig
import com.techmashinani.filamu.utils.addQuery
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton
/*
    Manipulates url requests and adds a query -
    - this is the api_key given by tmdb for authorization
 */
@Singleton
class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // get the request
        var request: Request = chain.request()
        if(request.header("auth") == null) {
            request = request.addQuery("api_key", BuildConfig.API_KEY)
        }
        return chain.proceed(request)
    }
}