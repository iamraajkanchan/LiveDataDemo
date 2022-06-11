package com.chinkyfamily.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * UserInfoViewModel is a ViewModel class for UserInfoActivity.
 * */
class UserInfoViewModel : ViewModel()
{
    /** Used to update user name in ViewModel. */
    private val usernameMutable : MutableLiveData<String> = MutableLiveData<String>()

    /** Used to get username from ViewModel */
    var username : LiveData<String> = usernameMutable

    /** Used to update user mobile number. */
    private val userMobileNumberMutable : MutableLiveData<String> = MutableLiveData<String>()

    /** Used to get userMobileNumber from ViewModel */
    var userMobileNumber : LiveData<String> = userMobileNumberMutable

    /**
     * updateUserName method is used in UserDetail fragment.
     * @param username first parameter.
     * */
    fun updateUserName(username : String?)
    {
        usernameMutable.value = username ?: return
    }

    /**
     * updateUserMobileNumber method is used in UserDetail fragment.
     * @param userMobileNumber first parameter.
     * */
    fun updateUserMobileNumber(userMobileNumber : String?)
    {
        userMobileNumberMutable.value = userMobileNumber ?: return
    }
}