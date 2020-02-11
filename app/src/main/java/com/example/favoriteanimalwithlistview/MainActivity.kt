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


        // Create a list of some strings that will be shown in the listview
        val animalList = listOf("dog", "cat", "bear", "rabbit")

        // Create an adapter with 3 parameters: activity (this), layout, list
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animalList)

        // set the adapter to listview
        animal_list.adapter = myAdapter


        // Registering setOnItemClickListener that listens item click events in the listview
        animal_list.setOnItemClickListener { list, item, position, id ->

            // Determine which item in the list is selected
            val selectedItem = list.getItemAtPosition(position).toString()
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()


            // Based on the index of position selected, set the corresponding image
            val imageId = when(position){
                0 -> R.drawable.dog
                1 -> R.drawable.cat
                2 -> R.drawable.bear
                else -> R.drawable.rabbit
            }

            image_animal.setImageResource(imageId)

        }
    }
}
