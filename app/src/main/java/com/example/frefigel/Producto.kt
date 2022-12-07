package com.example.frefigel

import java.io.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
class Producto (
    val nombre:String,
    val precio:Double,
    val descripcion:String,
    val imagen:Int,
    @PrimaryKey(autoGenerate = true)
    var idProducto: Int = 0

    ) : Serializable
