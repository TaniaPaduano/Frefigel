package com.example.frefigel.providers

import com.example.frefigel.api.ApiRoutes
import com.example.frefigel.models.ResponseHttp
import com.example.frefigel.models.User
import com.example.frefigel.routes.UsersRoutes
import retrofit2.Call

class UsersProvider {

    private var usersRoutes: UsersRoutes? = null

    init {
        val api = ApiRoutes()
        usersRoutes = api.getUsersRoutes()
    }

    fun register(user: User): Call<ResponseHttp>? {
        return usersRoutes?.register(user)
    }

    fun login(email: String, password: String): Call<ResponseHttp>? {
        return usersRoutes?.login(email, password)
    }

}