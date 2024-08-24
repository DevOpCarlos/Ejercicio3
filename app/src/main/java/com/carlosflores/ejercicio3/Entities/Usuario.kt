package com.carlosflores.ejercicio3.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [

    ForeignKey(
        entity = Persona::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_persona")
    )

])
data class Usuario(

    @PrimaryKey
    var id : Int?,

    @ColumnInfo(name = "username")
    var username : String,

    @ColumnInfo(name = "password")
    var password : String,

    @ColumnInfo(name = "active")
    var active : Boolean,

    @ColumnInfo(name = "id_persona")
    var idPersona : Int

)
