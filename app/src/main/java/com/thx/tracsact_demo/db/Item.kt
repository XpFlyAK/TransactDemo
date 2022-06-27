package com.thx.tracsact_demo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thx.tracsact_demo.contants.Constant

/**
 * Created by thxpf on 2022/6/26 22:14.
 *
 *  @email thxpfly@163.com
 *  @desc 定义数据库
 */
@Entity(tableName = Constant.TABLE_NAME)
class Item {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constant.ID, typeAffinity = ColumnInfo.INTEGER)
    var id: Int = 0

    @ColumnInfo(name = Constant.START_RATE, typeAffinity = ColumnInfo.REAL)
    var start_rate: Double = 0.0


    @ColumnInfo(name = Constant.END_RATE, typeAffinity = ColumnInfo.REAL)
    var end_rate: Double = 0.0


    @ColumnInfo(name = Constant.CHANGE, typeAffinity = ColumnInfo.REAL)
    var change: Double = 0.0

    @ColumnInfo(name = Constant.CHANGE_PCT, typeAffinity = ColumnInfo.REAL)
    var change_pct: Double = 0.0

    @ColumnInfo(name = Constant.TIME, typeAffinity = ColumnInfo.TEXT)
    var time: String = ""

    @ColumnInfo(name = Constant.TYPE, typeAffinity = ColumnInfo.TEXT)
    var type: String = ""

    override fun toString(): String {
        return " Item id=$id \n start_rate=$start_rate \n end_rate=$end_rate \n change=$change \n change_pct=$change_pct \n time='$time' \n type='$type'"
    }

}