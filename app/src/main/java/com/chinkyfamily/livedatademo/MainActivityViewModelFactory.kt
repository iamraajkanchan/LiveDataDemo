package com.chinkyfamily.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

/**
 * MainActivityViewModelFactory for MainActivityViewModel
 * */
class MainActivityViewModelFactory() : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass : Class<T>) : T
    {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java))
        {
            return MainActivityViewModel() as T
        }
        throw IllegalArgumentException("Local and anonymous classes can not be ViewModels")
    }
}