package com.example.myroomdb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myroomdb.data.db.ShoppingDao
import com.example.myroomdb.data.db.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {

    // getShoppingDao() function will helps to access the methods of DAO.
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        // Volatile : means if access by more than one Thread at a time,
        // it will provide only updated value to each thread after one thread completed
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db"
            ).build()
    }

}