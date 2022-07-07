package com.greemoid.cleanl1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import com.greemoid.cleanl1.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("VM", "Activity created")

        val tvData = findViewById<TextView>(R.id.tvData)
        val etData = findViewById<TextView>(R.id.etData)
        val btnGetData = findViewById<TextView>(R.id.btnGetData)
        val btnSaveData = findViewById<TextView>(R.id.btnSaveData)

        viewModel.result.observe(this, { text ->
            tvData.text = text
        })

        btnSaveData.setOnClickListener {
            val name = etData.text.toString()
            viewModel.save(name)
        }

        btnGetData.setOnClickListener {
            viewModel.load()
        }
    }
}