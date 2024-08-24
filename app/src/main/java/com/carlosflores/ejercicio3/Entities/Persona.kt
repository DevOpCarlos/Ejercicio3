package com.carlosflores.ejercicio3.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Persona (

    @PrimaryKey
    var id : Int?,

    @ColumnInfo(name = "primer_nombre")
    var primerNombre : String,

    @ColumnInfo(name = "primer_apellido")
    var primerApellido : String

)