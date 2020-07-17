package com.example.basicdaggertutorial.repository

import com.example.basicdaggertutorial.Api
import com.example.basicdaggertutorial.User
import retrofit2.*

class UserRepositoryImpl(private val api: Api) :
    UserRepository {

    override fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    onSuccess.invoke(user)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure.invoke(t)
            }
        })
    }
}