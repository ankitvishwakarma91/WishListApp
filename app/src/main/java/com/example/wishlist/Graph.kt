package com.example.wishlist

import android.content.Context
import androidx.room.Room
import com.example.wishlist.data.WishDatabase
import com.example.wishlist.data.WishesRepository

object Graph {

    lateinit var database : WishDatabase

    val wishRepository by lazy {
        WishesRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context,WishDatabase::class.java,"Wishlist.db").build()
    }
}