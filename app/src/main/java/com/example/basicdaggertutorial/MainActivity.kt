package com.example.basicdaggertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.basicdaggertutorial.viewmodel.MainViewModel
import com.example.basicdaggertutorial.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var fullName: TextView
    private lateinit var username: EditText
    private lateinit var search: Button

    @Inject
    lateinit var factory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        fullName = findViewById(R.id.full_name)
        username = findViewById(R.id.username)
        search = findViewById(R.id.search)

        viewModel.fullName.observe(this, Observer { name ->
            fullName.text = name
        })
    }

    override fun onStart() {
        super.onStart()
        search.setOnClickListener {
            viewModel.searchUser(username.text.toString())
        }
    }
}