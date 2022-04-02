package com.example.myroomdb.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.myroomdb.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllItems() : LiveData<List<ShoppingItem>>

}