package com.kotlin.test.api

import android.util.Log
import com.kotlin.test.constant.Constants
import com.orhanobut.logger.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Copyright (c), 2018-2018, CHAINCE
 * Author: lixin
 * Date: 2018/11/7
 * Description:
 */ 
class RetrofitUtil {

    companion object {
        val TAG: String = RetrofitUtil.javaClass.simpleName
        /**
         * 创建Retrofit
         */
        fun create(url: String): Retrofit {
            //日志显示级别
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            //新建log拦截器
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message -> Logger.e("OkHttp: " + message)
            })
            loggingInterceptor.level = level

            //OkHttpClient Builder
            val okHttpClientBuilder = OkHttpClient().newBuilder()

            okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)

            //OkHttp进行添加拦截器loggingInterceptor
            //OkHttpClientBuild.addInterceptor(loggingInterceptor)

            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        val retrofitService: RetrofitService = RetrofitUtil.getService(Constants.REQUEST_BASE_URL, RetrofitService::class.java)

        fun <T> getService(url: String, service: Class<T>): T {
            return create(url).create(service)
        }

    }

}