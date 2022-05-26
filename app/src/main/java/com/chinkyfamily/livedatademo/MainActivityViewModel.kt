package com.chinkyfamily.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * MainActivityViewModel class is used for MainActivity.
 * */
class MainActivityViewModel() : ViewModel()
{
    private var count = MutableLiveData<Int>()

    /**
     * This variable is used to access the data from ViewModel
     * */
    val totalCount : LiveData<Int>
        get() = count

    init
    {
        count.value = 0
    }

    /**
     * Use this method to add 1 in the MutableLiveData count
     * */
    fun updateTotal()
    {
        count.value = (count.value ?: return).plus(1)
    }
}