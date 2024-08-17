package com.carlosflores.ejercicio3.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(

    @PrimaryKey
    var id : Int?,

    @ColumnInfo(name = "username")
    var username : String,

    @ColumnInfo(name = "password")
    var password : String,

    @ColumnInfo(name = "active")
    var active : Boolean

)
