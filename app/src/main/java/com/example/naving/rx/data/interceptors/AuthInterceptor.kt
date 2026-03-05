package com.example.naving.rx.data.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(

) : Interceptor {

    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val BEARER = "Bearer"
        private const val DEVICE = "device"
        private const val LAT = "lat"
        private const val LONG = "long"
        private const val VERSION = "version"
        private const val LANGUAGE = "language"
        private const val STORE_VERSION = "storeVersion"

    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val token = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJTZXNzaW9uSWQiOiIwMTljYWViZS1jNzg0LTdhZGUtODUyYy1mNWNlNjJmNDhjZGUiLCJQbGF0Zm9ybSI6IkFORFJPSUQiLCJQcm9maWxlVHlwZSI6IkhBTEFOX1VTRVJfUFJPRklMRSIsIlZlcnNpb24iOiIxLjAiLCJpc3MiOiJoYWxhbi5pbyIsInN1YiI6IjY5YTU3NmVjNWE1MjNhMWQwY2NhNWJjNyIsImF1ZCI6WyJhdXRob3JpemF0aW9uIl0sImV4cCI6MTgwMzk5NDI2NCwiaWF0IjoxNzcyNDU4MjY0fQ.-eVgAaEOogW58snTymjrD3irzBrPxXRktrkjjz_DLqL6DVdpkbYWcliz_RELMgC8lmYQye9W-E0ixb6pZQ_JgA"
        val device = "phablet;google;sdk_gphone64_arm64;Android;16;Google;en;7200;1772451504;36400107;14e738e8-a172-44fd-8b84-9dc7adc98b8f"
        val lat = "30.044418334960938"
        val long = "31.23571014404297"
        val version = "36400107"
        val language = "en"
        val storeVersion = "6.3.20"

        val request = chain.request().newBuilder()
            .addHeader(AUTHORIZATION, "$BEARER $token")
            .addHeader(DEVICE, device)
            .addHeader(LAT, lat)
            .addHeader(LONG, long)
            .addHeader(VERSION, version)
            .addHeader(LANGUAGE, language)
            .addHeader(STORE_VERSION, storeVersion)
            .build()

        return chain.proceed(request)
    }
}