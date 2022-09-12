package com.example.ui_demo

import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.ui_demo.databinding.ActivityViewsDemoBinding

class ViewsDemoActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityViewsDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views_demo);
        RatingListener();
    }

    fun RatingListener(){
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val textToChange = findViewById<TextView>(R.id.textToChange)
        /*.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener {
            override fun onRatingChanged(ratBar: RatingBar?, rating: Float, fromUser: Boolean) {
                Log.d("ViewsDemoActivity", "Rating: $rating")
                textToChange.text = "Neue Bewertung: $rating"
            }
        })*/

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            Log.d("ViewsDemoActivity", "Rating: $rating")
            textToChange.text = "Neue Bewertung: $rating"
        }
    }
}