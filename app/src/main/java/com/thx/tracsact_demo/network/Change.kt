package com.thx.tracsact_demo.network

import com.thx.tracsact_demo.contants.Constant
import com.thx.tracsact_demo.db.Item

/**
 * Created by thxpf on 2022/6/26 16:20.
 *
 *  @email thxpfly@163.com
 *  @desc  change接口数据
 */
data class Change(
    val success: Boolean,
    val change: Boolean,
    val start_date: String,
    val end_date: String,
    val source: String = Constant.USD_STR,
    val quotes: Map<String, Item>
)


// Json demo

//{
//    "success": true,
//    "change": true,
//    "start_date": "2010-03-01",
//    "end_date": "2010-03-30",
//    "source": "CNY",
//    "quotes": {
//    "CNYAED": {
//        "start_rate": 0.537973,
//        "end_rate": 0.53807,
//        "change": 0.0001,
//        "change_pct": 0.018
//    },
//    "CNYAFN": {
//        "start_rate": 6.995479,
//        "end_rate": 6.742347,
//        "change": -0.2531,
//        "change_pct": -3.6185
//    },
//    "CNYUSD": {
//        "start_rate": 15.064086,
//        "end_rate": 15.137786,
//        "change": 0.0737,
//        "change_pct": 0.4892
//    },
//}
//}