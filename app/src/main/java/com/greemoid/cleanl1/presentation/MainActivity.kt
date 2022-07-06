package com.greemoid.cleanl1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.greemoid.cleanl1.R
import com.greemoid.cleanl1.data.repositories.UserRepositoryImpl
import com.greemoid.cleanl1.data.storage.UserStorage
import com.greemoid.cleanl1.data.storage.sharedprefs.SharedPrefUserStorage
import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

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