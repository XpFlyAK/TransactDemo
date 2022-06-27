package com.thx.tracsact_demo.repository

import com.thx.tracsact_demo.base.App
import com.thx.tracsact_demo.contants.Constant
import com.thx.tracsact_demo.db.Item
import com.thx.tracsact_demo.db.ItemDao
import com.thx.tracsact_demo.db.ItemDataBase
import com.thx.tracsact_demo.network.NetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Created by thxpf on 2022/6/26 15:44.
 *
 *  @email thxpfly@163.com
 *  @desc  数据处理
 */
object DataRepository {

    /*
    *  处理change接口数据
    */
    suspend fun fetchTransactChange(source: String, startData: String, endData: String) =
        withContext(Dispatchers.IO) {
            val changeData = NetWork.requestChangeData(startData, endData, source)
            // 拼接 USDCNY
            val key = if(changeData.source == Constant.CNY_STR) Constant.CNY_STR + Constant.USD_STR else Constant.USD_STR + Constant.CNY_STR
            // 只取出数据中的 USDCNY 和  CNYUSD的键值对 存入
            val item = changeData.quotes[key]
            item?.apply {
                time = Calendar.getInstance().time.toString()
                type = key
            }

            ItemDataBase.getInstance(App.getApplication).itemDao().insertItem(item!!)
            changeData
        }

    /*
    *  查询
    */
    suspend fun queryItemList():List<Item> =
        withContext(Dispatchers.IO){
            val queryItems = ItemDataBase.getInstance(App.getApplication).itemDao().queryItems()
            queryItems
        }


}