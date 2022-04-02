package com.example.myroomdb.data.repositories

import com.example.myroomdb.data.ShoppingDatabase
import com.example.myroomdb.data.db.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllItems() = db.getShoppingDao().getAllItems()

}