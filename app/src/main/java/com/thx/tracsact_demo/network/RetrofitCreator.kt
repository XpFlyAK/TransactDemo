package com.thx.tracsact_demo.network

import com.thx.tracsact_demo.contants.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by thxpf on 2022/6/26 15:55.
 *
 *  @email thxpfly@163.com
 *  @desc  Retrofit定义
 */

object RetrofitCreator{

    private const val BASE_URL = Constant.BASE_URL

    private val mClient = OkHttpClient.Builder()
            .connectTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10 , TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .build()

    private val mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun<T> create(clazz: Class<T>) : T = mRetrofit.create(clazz)
}