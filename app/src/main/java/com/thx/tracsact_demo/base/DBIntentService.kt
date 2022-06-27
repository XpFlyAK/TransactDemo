package com.thx.tracsact_demo.base

import android.app.IntentService
import android.content.Intent
import com.thx.tracsact_demo.contants.Constant
import com.thx.tracsact_demo.db.ItemDataBase

/**
 * Created by thxpf on 2022/6/27 12:15.
 *
 *  @email thxpfly@163.com
 *  @desc  初始化db
 */
class DBIntentService : IntentService(Constant.DB_INIT_THREAD) {

    override fun onHandleIntent(intent: Intent?) {
        ItemDataBase.getInstance(App.getApplication)
    }

}