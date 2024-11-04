package com.example.myplanetapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //1- The View: List View
        val myListview: ListView = findViewById(R.id.listView)


        //2 - Data source saved in Planets class
        val planet1 = Planets("Chest", "4 Exercises", R.drawable.chest)
        val planet2 = Planets("Shoulders", "4 Exercises", R.drawable.shoulder)
        val planet3 = Planets("Triceps", "4 Exercises", R.drawable.triceps)
        val planet4 = Planets("Back", "2 Exercises", R.drawable.back)
        val planet5 = Planets("Biceps", "2 Exercises", R.drawable.biceps)
        val planet6 = Planets("Legs", "4 Exercises", R.drawable.legs)
        val planet7 = Planets("Forearms", "3 Exercises", R.drawable.forearm)

        // Initialize a list to hold planets data
        val planets = arrayListOf(
            planet1, // Add the first planet
            planet2, // Add the second planet
            planet3, // Add the third planet
            planet4, // Add the fourth planet
            planet5, // Add the fifth planet
            planet6, // Add the sixth planet
            planet7  // Add the seventh planet
        )

        //This will work as well
//        var planets = ArrayList<Planets>()
//        planets.add(planet1)
//        planets.add(planet2)
//        planets.add(planet3)
//        planets.add(planet4)
//        planets.add(planet5)
//        planets.add(planet6)
//        planets.add(planet7)


        //3 - Adapter
        val myCustomAdapter = myCustomAdapter(this, this, planets)
        myListview.adapter = myCustomAdapter





    }
}