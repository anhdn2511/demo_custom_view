package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val l = findViewById<LinearLayout>(R.id.l)
//        val tv = CustomView(this)
//        tv.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
//        l.addView(tv)
//        tv.mEmail = "abc@gmail.com"
//        tv.otp = "123456"
    }
}