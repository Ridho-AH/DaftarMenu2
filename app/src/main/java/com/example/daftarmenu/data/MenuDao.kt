package com.example.daftarmenu.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahMakanan(makananModel: MakananModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahMinuman(minumanModel: MinumanModel)

    @Query("Select * from MakananModel")
    fun ambilMenuMakanan():LiveData<List<MakananModel>>

    @Query("Select * from MinumanModel")
    fun ambilMenuMinuman():LiveData<List<MinumanModel>>
}