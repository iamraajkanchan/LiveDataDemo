package com.chinkyfamily.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

/**
 * UserInfoViewModelFactory is used to offer UserInfoViewModel to UserInfoActivity.
 * */
class UserInfoViewModelFactory : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass : Class<T>) : T
    {
        if (modelClass.isAssignableFrom(UserInfoViewModel::class.java))
        {
            return UserInfoViewModel() as T
        }
        throw IllegalArgumentException("Local and anonymous classes can not be ViewModels")
    }
}