package com.example.ui_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_demo_activity)
        setListeners();
    }


    fun setListeners() {
        val radioGroup = findViewById<RadioGroup>(R.id.radianStyle)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val intent = Intent(this, layoutDemo::class.java)
            Log.i(
                "checked id: ",
                (checkedId == findViewById<RadioButton>(R.id.radioButtonLinearLayout).id).toString()
            )

            intent.putExtra(
                "isLinearLayout",
                (checkedId == findViewById<RadioButton>(R.id.radioButtonLinearLayout).id)
            )
            startActivity(intent);
        }
    }

    fun onClickDemo(v: View)
    {
        val intent = Intent(this, ViewsDemoActivity::class.java);
        startActivity(intent);
    }
}