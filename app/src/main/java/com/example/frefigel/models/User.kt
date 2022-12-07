package com.example.frefigel.models

import com.google.gson.annotations.SerializedName

class  User(
@SerializedName("id") val id: String? = null,
@SerializedName("name") val name: String,
@SerializedName("slug") val slug: String? = null,
@SerializedName("address") val address: String,
@SerializedName("email") val email: String,
@SerializedName("password") val password: String,
@SerializedName("role") val role: String,
@SerializedName("remember_token") val remember_token: String? = null,



) {

    override fun toString(): String {
        return "User(id='$id', name='$name', slug='$slug',address='$address', email='$email', password='$password',role='$role', remember_token='$remember_token')"
    }
}