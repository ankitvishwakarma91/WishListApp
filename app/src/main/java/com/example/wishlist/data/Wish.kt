package com.example.wishlist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
data class Wish(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "wish-title")
    val title: String = "",

    @ColumnInfo(name = "wish-desc")
    val description: String = ""

)

object DummyWish {
    val wishList = listOf(
        Wish(title = "Iphone 16 ", description = "I will buy when i earn money more than enough"),
        Wish(
            title = "Sumsung Galaxy s25 ultra ",
            description = "I will buy when i earn money more than enough"
        ),
        Wish(title = "Mac Book ", description = "I will buy when i earn money more than enough"),
        Wish(title = "I pad ", description = " i will somet "),
        Wish(title = "Earbuds ", description = " i have already  "),
        Wish(title = "Bag ", description = " i have new bag  "),

        )


}
