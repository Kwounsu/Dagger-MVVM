package com.example.basicdaggertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var fullName: TextView
    private lateinit var username: EditText
    private lateinit var search: Button

    @Inject
    lateinit var api: Api

    private lateinit var viewModel: MainViewModel
    private lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        factory = MainViewModelFactory(api)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

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
            searchUser(username.text.toString())
        }
    }

    private fun searchUser(username: String) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    fullName.text = user.name
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ", t)
            }
        })
    }
}