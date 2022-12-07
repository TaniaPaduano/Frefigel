package com.example.frefigel.api

import com.example.frefigel.routes.UsersRoutes

class ApiRoutes {

    val API_URL = "https://www.proyectos.dsgys.com/api/"
    val retrofit = RetrofitClient()

    fun getUsersRoutes(): UsersRoutes {
        return retrofit.getClient(API_URL).create(UsersRoutes::class.java)
    }

}