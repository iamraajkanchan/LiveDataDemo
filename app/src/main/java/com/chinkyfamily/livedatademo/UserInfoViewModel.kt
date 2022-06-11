package com.chinkyfamily.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserInfoViewModel : ViewModel()
{
    /** Used to store user name */
    private val userNameMutable : MutableLiveData<String> = MutableLiveData<String>()
    var userName : LiveData<String> = userNameMutable

    /** Used to store user mobile number */
    private val userMobileNumberMutable : MutableLiveData<String> = MutableLiveData<String>()
    var userMobileNumber : LiveData<String> = userMobileNumberMutable
}