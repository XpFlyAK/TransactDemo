package com.thx.tracsact_demo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


/**
 * Created by thxpf on 2022/6/26 22:10.
 *
 *  @email thxpfly@163.com
 *  @desc  定义数据库功能
 */
@Dao
interface ItemDao {

    @Insert
    fun insertItem(item:Item)


    @Query("SELECT * FROM item")
    fun queryItems():List<Item>

}