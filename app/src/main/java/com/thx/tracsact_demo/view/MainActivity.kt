package com.thx.tracsact_demo.view

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thx.tracsact_demo.R
import com.thx.tracsact_demo.db.Item
import com.thx.tracsact_demo.viewmodel.MainViewModel


/**
 * Created by thxpf on 2022/6/26 22:10.
 *
 *  @email thxpfly@163.com
 *  @desc  主页面
 */
class MainActivity : ComponentActivity(), RadioGroup.OnCheckedChangeListener {

    private lateinit var tvShow: TextView
    private lateinit var btnQuery: TextView
    private lateinit var rbCNY: RadioButton
    private lateinit var rbUSD: RadioButton
    private lateinit var rbTransactGroup: RadioGroup

    lateinit var mViewModel: MainViewModel

    private val itemListStr = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        tvShow = findViewById(R.id.tv)
        btnQuery = findViewById(R.id.btn)
        rbCNY = findViewById(R.id.rb_cny)
        rbUSD = findViewById(R.id.rb_usd)
        rbTransactGroup = findViewById(R.id.rb_transact_group)

        //默认状态
        rbUSD.isChecked = true
        mViewModel.CNYChecked.value = !rbUSD.isChecked

        rbTransactGroup.setOnCheckedChangeListener(this)

        btnQuery.setOnClickListener {
            mViewModel.queryChangeData()
        }


        mViewModel.queryLocalChange()
        addObserve()

    }

    private fun addObserve() {
        // 数据条目
        mViewModel.itemList.observe(this, Observer<List<Item>> {
            itemListStr.clear()
            it.forEach { item ->
                itemListStr.append(item.toString())
                itemListStr.append("\n")
            }
            tvShow.text = if (itemListStr.isEmpty()) getString(R.string.welcome)else itemListStr.toString()
        })


        // 错误信息显示
        mViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when (p1) {
            R.id.rb_usd -> {
                rbUSD.isChecked = true
                mViewModel.CNYChecked.value = !rbUSD.isChecked
            }
            R.id.rb_cny -> {
                rbCNY.isChecked = true
                mViewModel.CNYChecked.value = !rbUSD.isChecked
            }
        }
    }
}


