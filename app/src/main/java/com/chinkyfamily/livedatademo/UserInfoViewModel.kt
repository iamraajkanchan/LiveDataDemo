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

    /** Used to update user mobile number. */
    private val userMobileNumberMutable : MutableLiveData<String> = MutableLiveData<String>()

    init
    {
        println("UserInfoViewModel :: userNameMutable : ${getUserName().value}")
        println("UserInfoViewModel :: userMobileNumberMutable : ${getUserMobileNumber().value}")
    }

    /**
     * updateUserName method is used in UserDetail Fragment.
     * @param username first parameter.
     * */
    fun updateUserName(username : String?)
    {
        usernameMutable.value = username ?: return
        println("UserInfoViewModel :: updateUserName :: usernameMutable : ${usernameMutable.value}")
    }

    /** getUserName method is used in ReviewDetail Fragment. */
    fun getUserName() : LiveData<String> = usernameMutable

    /**
     * updateUserMobileNumber method is used in UserDetail Fragment.
     * @param userMobileNumber first parameter.
     * */
    fun updateUserMobileNumber(userMobileNumber : String?)
    {
        userMobileNumberMutable.value = userMobileNumber ?: return
        println("UserInfoViewModel :: updateUserMobileNumber :: userMobileNumberMutable : ${userMobileNumberMutable.value}")
    }

    /** getUserMobileNumber method is used in ReviewDetail Fragment. */
    fun getUserMobileNumber() : LiveData<String> = userMobileNumberMutable
}