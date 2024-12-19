package com.example.people_spisok

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var peopleListView: ListView
    private lateinit var nameEditText: EditText
    private lateinit var peopleList: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        peopleListView = findViewById(R.id.peopleListView)
        nameEditText = findViewById(R.id.editTextName)

        val firstNames = resources.getStringArray(R.array.first_names)
        val lastNames = resources.getStringArray(R.array.last_names)

        peopleList = mutableListOf<String>()
        for (i in 0 until 10) {
            val randomFirstName = firstNames[Random.nextInt(firstNames.size)]
            val randomLastName = lastNames[Random.nextInt(lastNames.size)]
            peopleList.add("$randomFirstName $randomLastName")
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, peopleList)
        peopleListView.adapter = adapter
    }


    fun onAddPersonClick(view: View) {
        val newName = nameEditText.text.toString()

        if (newName.isNotEmpty()) {
            peopleList.add(newName)
            adapter.notifyDataSetChanged()
            nameEditText.text.clear()
        }
    }
}
