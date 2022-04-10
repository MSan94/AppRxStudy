package com.example.myapplication

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.myapplication.databinding.ActivityBaseBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity(){

    /** 툴바여부 **/
    protected abstract val isToolBar : Boolean

    /** 레이아웃 리소스 **/
    @get:LayoutRes
    protected abstract val resId : Int

    private val binding by lazy { ActivityBaseBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        layoutInflater.inflate(resId,binding.flContent,true) // 액티비티 할당

        when(isToolBar){
            true -> { binding.clToolBar.visibility = View.VISIBLE }
            else -> { binding.clToolBar.visibility = View.GONE }
        }

        if(binding.dlView.isDrawerOpen(binding.viewMenu)){
            binding.dlView.closeDrawer(binding.viewMenu)
        }

        binding.tvMenu.setOnClickListener{
            binding.dlView.openDrawer(binding.viewMenu)
        }

        binding.tvBack.setOnClickListener {
            finish()
        }

    }

    protected fun setTitle(title : String){
        binding.tvTitle.text = title
    }

}