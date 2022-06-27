package com.thx.tracsact_demo.network

import com.thx.tracsact_demo.contants.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Created by thxpf on 2022/6/26 16:30.
 *
 *  @email thxpfly@163.com
 *  @desc  回调封装
 */
object NetWork {

    private val placeService = RetrofitCreator.create(ChangeService::class.java)

    suspend fun requestChangeData(startDate: String, endDate: String, source: String) =
        placeService.requestChangeData(startDate, endDate, source).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine {
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null)
                        it.resume(body)
                    else
                        it.resumeWithException(Exception(Constant.NULL_BODY))
                }

            })
        }

    }


}