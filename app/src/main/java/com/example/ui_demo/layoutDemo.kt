package com.example.ui_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class layoutDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent : Intent = intent;
        val isLinearLayout : Boolean = intent.getBooleanExtra("isLinearLayout", true)!!

        if(isLinearLayout)
            setContentView(R.layout.linear_layout)
        else setContentView(R.layout.bestelung)
    }
}