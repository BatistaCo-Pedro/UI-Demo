package com.example.ui_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_demo_activity)
        setListeners();
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        val myLinearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        Snackbar.make(myLinearLayout, "${item.title} wurde geclickt", Snackbar.LENGTH_LONG).show()
        return true
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

    fun lol()
    {

    }

    fun onClickDemo(v: View)
    {
        val intent = Intent(this, ViewsDemoActivity::class.java);
        startActivity(intent);
    }
}