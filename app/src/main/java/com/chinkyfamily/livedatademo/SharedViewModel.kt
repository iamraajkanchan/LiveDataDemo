package com.chinkyfamily.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * SharedViewModel is a ViewModel created for TutorialActivity.
 * */
class SharedViewModel : ViewModel()
{
    private val text = MutableLiveData<String>()

    /**
     * setText method is used in FragmentA
     * */
    fun setText(input : String)
    {
        text.value = input
    }

    /**
     * getText method is used in FragmentB
     * */
    fun getText() : LiveData<String> = text
}