package com.example.myroomdb.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_amout")
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}