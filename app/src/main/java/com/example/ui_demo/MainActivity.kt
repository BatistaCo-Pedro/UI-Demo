package com.example.ui_demo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_demo_activity)
        setListeners()
        setAdapterView()
    }

    fun setAdapterView(){
        val myArray = getResources().getStringArray(R.array.itCourses)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, myArray)
        val mySpinner = findViewById<Spinner>(R.id.spinner)
        mySpinner.adapter = adapter
    }

//    public void onItemSelected(AdapterView<?> parent,
//    View view, int pos, long id) {
//        Toast.makeText(parent.getContext()), "The planet is " +
//        parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
//    }
//
//    public void onNothingSelected(AdapterView parent) {
//        // Do nothing.
//    }

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

    fun onClickDemo(v: View)
    {
        val intent = Intent(this, ViewsDemoActivity::class.java);
        startActivity(intent);
    }
}