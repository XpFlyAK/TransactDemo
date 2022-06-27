package com.thx.tracsact_demo.network

import com.thx.tracsact_demo.contants.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by thxpf on 2022/6/26 16:04.
 *
 *  @email thxpfly@163.com
 *  @desc  change接口
 */
interface ChangeService {

    @Headers(Constant.API_KEY)
    @GET(Constant.CURRENCY_DATA_CHANGE)
    fun requestChangeData(
        @Query(Constant.START_DATE) startDate: String,
        @Query(Constant.END_DATE) endDate: String,
        @Query(Constant.SOURCE) source: String
    ): Call<Change>

}