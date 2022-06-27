package com.thx.tracsact_demo.db

import android.content.Context
import androidx.room.*
import com.thx.tracsact_demo.contants.Constant

/**
 * Created by thxpf on 2022/6/26 22:25.
 *
 *  @email thxpfly@163.com
 *  @desc  创建数据库
 */
@Database(entities = [Item::class], version = 1)
abstract class ItemDataBase : RoomDatabase(){

    companion object{

        private const val dbName = Constant.DB_NAME

        private var itemDataBase : ItemDataBase ?= null

        fun getInstance(context: Context) : ItemDataBase {
            if(itemDataBase == null){
                synchronized(ItemDataBase::class){
                    if(itemDataBase == null){
                        itemDataBase = Room.databaseBuilder(context, ItemDataBase::class.java, dbName).build()
                    }
                }
            }
            return itemDataBase!!
        }
    }


    abstract fun itemDao():ItemDao

}