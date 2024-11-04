package com.example.myplanetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ChestWorkOutPage : AppCompatActivity() {

    lateinit var myImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chest_work_out_page)

        val receivedData = intent.getIntExtra("position", 0)

        Toast.makeText(this, "Position $receivedData was clicked", Toast.LENGTH_SHORT).show()

        myImage = findViewById<ImageView>(R.id.imageView)

        when(receivedData) {
            0-> myImage.setImageResource(R.drawable.chestworkout)
            1-> myImage.setImageResource(R.drawable.shoulderworkout)
            2-> myImage.setImageResource(R.drawable.tricepsworkout)
            3-> myImage.setImageResource(R.drawable.backworkout2)
            4-> myImage.setImageResource(R.drawable.bicepsworkout)
            5-> myImage.setImageResource(R.drawable.legsworkout)
            6-> myImage.setImageResource(R.drawable.forearmworkout)
        }




    }
}