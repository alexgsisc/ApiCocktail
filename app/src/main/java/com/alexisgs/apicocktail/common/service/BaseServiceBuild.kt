package com.alexisgs.apicocktail.common.service

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  Created by Alexis Guadarrama on 29/07/20.
 */
abstract class BaseServiceBuild<T : Any> {

    var retrofitBuild: Retrofit.Builder
    /*private var interceptors: Interceptor

    protected constructor(interceptor: Interceptor? = GenericInterceptor()) {
        this.interceptors = interceptor!!
    }*/

    init {

        val loginInterceptor = HttpLoggingInterceptor()
        loginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClientBuilder = OkHttpClient().newBuilder()

        okHttpClientBuilder
            .addInterceptor(loginInterceptor)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .retryOnConnectionFailure(false)
        val client = okHttpClientBuilder.build()
        retrofitBuild = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())


    }


    abstract fun build(): T


    /*class GenericInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request?.newBuilder()
                ?.addHeader("Content-Type", "application/json")
                ?.addHeader("Accept", "application/json")
                ?.build()
            Log.d("Request", request.toString())
            return chain.proceed(request)

        }
    }*/
}