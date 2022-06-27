package com.thx.tracsact_demo.base

import android.app.Application
import android.content.Intent

/**
 * Created by thxpf on 2022/6/26 22:28.
 *
 *  @email thxpfly@163.com
 *  @desc  App
 */
class App : Application(){

    companion object{
        lateinit var getApplication : App
    }

    override fun onCreate() {
        super.onCreate()

        getApplication = this

        val intent = Intent(this,DBIntentService::class.java)
        startService(intent)
    }

}