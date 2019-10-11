package com.example.daftarmenu.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MakananModel (
    @PrimaryKey(autoGenerate = true)
    var idMenu:Int?=null,
    var namaMenu:String,
    var hargaMenu:String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var gambarMenu:ByteArray?
)
