package com.example.favoriteanimalwithlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animalList = listOf("dog", "cat", "bear", "rabbit")

        val myAdopter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,animalList)

        animal_list.adapter = myAdopter


        animal_list.setOnItemClickListener { list, item, position, id ->

            val selectedItem = list.getItemAtPosition(position).toString()
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()

            var imageId = when(position){
                0 -> R.drawable.dog
                1 -> R.drawable.cat
                2 -> R.drawable.bear
                else -> R.drawable.rabbit
            }

            image_animal.setImageResource(imageId)

        }
    }
}
