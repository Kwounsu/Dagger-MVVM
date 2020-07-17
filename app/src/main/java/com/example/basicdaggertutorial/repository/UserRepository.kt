package com.example.basicdaggertutorial.repository

import com.example.basicdaggertutorial.User

interface UserRepository {

    fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit)
}