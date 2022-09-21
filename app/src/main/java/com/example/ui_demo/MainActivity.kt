package com.example.ui_demo

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ui_demo.databinding.ActivityMainBinding.inflate
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var viewModel : MainViewModel? = null
//    val rLinearLayout = findViewById<LinearLayout>(R.id.linearLayout)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_demo_activity)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val mySpinner = findViewById<Spinner>(R.id.spinner)
        val myDialogSpinner = findViewById<Spinner>(R.id.spinner2)
        setListeners()
//        setAdapterView()

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) { }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(view == null) return
                val selectedItem : String = parent?.getItemAtPosition(position).toString()
                Snackbar.make(view, "${selectedItem} wurde geclickt", Snackbar.LENGTH_LONG).show()
            }
        }
        myDialogSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) { }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(view == null) return
                val selectedItem = parent?.getItemAtPosition(position).toString()
                when (selectedItem) {
                    "-" -> Log.d("Dialogs", "-")
                    "Dialog ohne Daten" -> showDialogOhneDaten(view)
                    "Dialog mit Daten" -> showDialogMitDaten(view)
                    "Custom Dialog" -> showCustomDialog(view)
                }
            }
        }
    }

    fun showCustomDialog(view: View) {
        val dialogBuilder : AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        val customView: View = layoutInflater.inflate(R.layout.custom_dialog_layout, null)

        dialogBuilder.setTitle("Bug Report")
            .setView(customView)
            .setPositiveButton("Senden") {_, _ ->
                Snackbar.make(view, "ok", Snackbar.LENGTH_LONG).show()
            }
            .show()
    }

    fun showDialogMitDaten(view: View) {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)

        dialogBuilder.setTitle("Wähle ein Getränk")
            .setItems(arrayOf("Kaffee", "Tea", "Wasser")) { _, pos ->
                when (pos) {
                    0 -> {
                        Toast.makeText(this@MainActivity, "Kaffee selected", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        Toast.makeText(this@MainActivity, "Tee ausgewählt", Toast.LENGTH_LONG).show()
                    }
                    2 -> {
                        Toast.makeText(this@MainActivity, "Wasser wurde ausgewählt", Toast.LENGTH_LONG).show()
                    }
                }
            }
            .show()
    }

//    fun setAdapterView(){
//        val myArray = getResources().getStringArray(R.array.itCourses)
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, myArray)
//        val mySpinner = findViewById<Spinner>(R.id.spinner)
//        mySpinner.adapter = adapter
//    }

    fun showDialogOhneDaten(view : View){
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)

        dialogBuilder.setTitle("ReaktorProblem")
            .setIcon(R.drawable.ic_power_plant_svgrepo_com__1_)
            .setMessage("Kühlwasserzufuhr unterbrochen! \nWas nun")
            .setPositiveButton("Abschalten", { _, _ ->
                Snackbar.make(view, "Reaktor wird abgeschaltet...", Snackbar.LENGTH_LONG).show()})
            .setNeutralButton("Weiss nicht", { _, _ ->
                Snackbar.make(view, "Problem an Support weiterleitet...", Snackbar.LENGTH_LONG).show()})
            .setNegativeButton("Abwarten", { _, _ -> /* nothing */ })
            .show()
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

    fun onClickDemo(v: View)
    {
        val intent = Intent(this, ViewsDemoActivity::class.java);
        startActivity(intent);
    }
}

class MainViewModel : ViewModel() {
    var counter = 0
        private set
    fun incrementCounter() {
        counter++
    }
}