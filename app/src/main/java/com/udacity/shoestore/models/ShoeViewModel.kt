package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    /**
     * This will be used for Databinding.
     */
    var newShoe:Shoe? = Shoe("","","","", listOf())
    private val shoes = mutableListOf<Shoe>()
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        Log.i("Shoe View Model", "View Model is Initialized")
    }

    fun addShoe(){
        shoes.add(Shoe(newShoe!!.name,newShoe!!.size,newShoe!!.company,newShoe!!.description, newShoe!!.images))
        _shoeList.value = shoes
    }




}