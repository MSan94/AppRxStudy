package com.example.myapplication.screen.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.BaseActivity
import com.example.myapplication.R
import com.example.myapplication.contract.MainContract
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.screen.sub.SubActivity

class MainActivity : BaseActivity<ActivityMainBinding>(), MainContract.Presenter {

    override val isToolBar: Boolean = true
    override val resId: Int = R.layout.activity_main

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var btNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MainActivity")
        init()
    }

    private fun init(){
        btNext = findViewById<Button>(R.id.btNext)
        btNext.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}