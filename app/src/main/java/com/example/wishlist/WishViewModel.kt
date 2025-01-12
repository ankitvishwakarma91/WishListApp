package com.example.wishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlist.data.Wish
import com.example.wishlist.data.WishesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishesRepository: WishesRepository = Graph.wishRepository
):ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString:String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString:String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes:Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishesRepository.getWishes()
        }
    }

    fun addWishes(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishesRepository.addWish(wish = wish)
        }
    }

    fun getAWishById(id:Long):Flow<Wish>{
        return wishesRepository.getAWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishesRepository.updateWish(wish = wish)
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishesRepository.deleteWish(wish = wish)
        }
    }

}