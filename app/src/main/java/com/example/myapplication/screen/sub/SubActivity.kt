package com.example.myapplication.screen.sub

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.myapplication.BaseActivity
import com.example.myapplication.R
import com.example.myapplication.contract.SubContract
import com.example.myapplication.databinding.ActivitySubBinding
import com.example.myapplication.databinding.ItemTestBinding
import io.reactivex.Observable
import java.lang.Thread.sleep
import kotlin.concurrent.thread

class SubActivity : BaseActivity<ActivitySubBinding>(), SubContract.View {

    override val isToolBar: Boolean = true
    override val resId: Int = R.layout.activity_sub

    val dataList = mutableListOf<String>()

    private val presneter by lazy {
        SubPresneter(this)
    }

    lateinit var btGet : Button
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("SubActivity")
        init()
        initListener()
    }

    private fun init(){
        btGet = findViewById(R.id.btGet)
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun initListener(){
        btGet.setOnClickListener {
            presneter.getData()
        }
    }

    override fun setData(data : String) {
        dataList.add(data)
    }

    override fun setRecycler(){
        val adapter = SubAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    inner class SubAdapter() : RecyclerView.Adapter<SubAdapter.Holder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubAdapter.Holder {
            val binding = ItemTestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return Holder(binding)
        }

        override fun onBindViewHolder(holder: SubAdapter.Holder, position: Int) {
            holder.setText(dataList[position])
        }

        override fun getItemCount(): Int = dataList.size

        inner class Holder(val binding : ItemTestBinding) : RecyclerView.ViewHolder(binding.root) {
            fun setText(text : String){
                binding.tvText.text = text
            }
        }
    }

}
