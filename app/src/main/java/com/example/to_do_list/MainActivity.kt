package com.example.to_do_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var taskAdapter: TaskAdapter
    private  val tasklist = mutableListOf<Tugas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskAdapter = TaskAdapter(tasklist)
        val layoutManager = LinearLayoutManager(this)
        val recyclerViewTask = findViewById<RecyclerView>(R.id.list_item)

        recyclerViewTask.layoutManager = layoutManager
        recyclerViewTask.adapter = taskAdapter

        val ButtonTambah = findViewById<Button>(R.id.ButtonTambah)
        val editTextTask = findViewById<EditText>(R.id.editTask)

      ButtonTambah.setOnClickListener {
            val taskTitle = editTextTask.text.toString()
            if(taskTitle.isNotEmpty()) {
                val newTask = Tugas(taskTitle)
                tasklist.add(newTask)
                taskAdapter.notifyDataSetChanged()
               editTextTask.text.clear()
            }
        }
    }
}