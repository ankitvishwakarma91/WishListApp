package com.example.wishlist.data

import kotlinx.coroutines.flow.Flow


class WishesRepository(private  val wishDao: WishDao) {

    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }

    fun getWishes():Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id:Long):Flow<Wish> {
        return wishDao.getAWishById(id)
    }

    suspend fun updateWish(wish: Wish){
        wishDao.updateWishes(wish)
    }

    suspend fun deleteWish(wish: Wish){
        wishDao.deleteAWishes(wish)
    }
}