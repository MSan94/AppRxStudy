package com.example.myapplication.screen.sub

import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myapplication.BaseActivity
import com.example.myapplication.R
import com.example.myapplication.contract.SubContract
import com.example.myapplication.databinding.ActivitySubBinding
import io.reactivex.Observable

class SubActivity : BaseActivity<ActivitySubBinding>(), SubContract.View {

    override val isToolBar: Boolean = true
    override val resId: Int = R.layout.activity_sub

    private val presneter by lazy {
        SubPresneter(this)
    }

    lateinit var btGet : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("SubActivity")
        init()
        initListener()
    }

    private fun init(){
        btGet = findViewById(R.id.btGet)
    }

    private fun initListener(){
        btGet.setOnClickListener {
            presneter.getData()
        }
    }

    override fun setData(data : String) {
        Log.d("TestData", "$data")
    }

}