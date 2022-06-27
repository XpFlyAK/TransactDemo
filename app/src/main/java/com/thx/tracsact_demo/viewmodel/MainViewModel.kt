package com.thx.tracsact_demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thx.tracsact_demo.contants.Constant
import com.thx.tracsact_demo.db.Item
import com.thx.tracsact_demo.repository.DataRepository
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Created by thxpf on 2022/6/26 15:33.
 *
 *  @email thxpfly@163.com
 *  @desc  主页面ViewModel
 */
class MainViewModel : ViewModel() {

    // 美元人民币二选一
    val CNYChecked = MutableLiveData<Boolean>()

    // 提示信息
    val errorMessage = MutableLiveData<String>()

    // 数据条目
    var itemList = MutableLiveData<List<Item>>()

    /*
    *  查询 填充 数据
    *  查询时间设置为固定 2010 3月 不做时间选择处理
    */
    fun queryChangeData() {
        lunch({
            errorMessage.value = Constant.LOADING
            DataRepository.fetchTransactChange(
                if (CNYChecked.value == true) Constant.CNY_STR else Constant.USD_STR,
                "2010-03-01",
                "2010-03-30"
            )
            val queryItems = DataRepository.queryItemList()
            itemList.value = queryItems
        }, {
            errorMessage.value = it.message
        })
    }


    // 本地查询
    fun queryLocalChange() {
        lunch({
            val queryItems = DataRepository.queryItemList()
            itemList.value = queryItems
        }, {
            errorMessage.value = it.message
        })
    }

    private fun lunch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                error(e)
            }
        }
    }

}