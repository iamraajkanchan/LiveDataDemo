package com.chinkyfamily.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * UserInfoViewModel is a ViewModel class for UserInfoActivity.
 * */
class UserInfoViewModel : ViewModel()
{
    /** Used to update username in ViewModel. */
    private val usernameMutable : MutableLiveData<String> = MutableLiveData<String>()

    /** Used to get username from ViewModel. */
    var username : LiveData<String> = usernameMutable

    /** Used to update user mobile number. */
    private val userMobileNumberMutable : MutableLiveData<String> = MutableLiveData<String>()

    /** Used to get userMobileNumber from ViewModel. */
    var userMobileNumber : LiveData<String> = userMobileNumberMutable

    /** Used to update address in ViewModel. */
    private val userAddressMutable : MutableLiveData<String> = MutableLiveData<String>()

    /** Used to get userAddress from ViewModel. */
    var userAddress : LiveData<String> = userAddressMutable

    /** Used to update state name in ViewModel */
    private val userStateNameMutable : MutableLiveData<String> = MutableLiveData<String>()

    /** Used to get userStateName from ViewModel */
    var userStateName : LiveData<String> = userStateNameMutable

    /**
     * updateUserName method is used in UserDetail Fragment.
     * @param username first parameter.
     * */
    fun updateUserName(username : String?)
    {
        usernameMutable.value = username ?: return
    }

    /**
     * updateUserMobileNumber method is used in UserDetail Fragment.
     * @param userMobileNumber first parameter.
     * */
    fun updateUserMobileNumber(userMobileNumber : String?)
    {
        userMobileNumberMutable.value = userMobileNumber ?: return
    }

    /**
     * updateAddress method is used in UserAddressDetail Fragment.
     * */
    fun updateUserAddress(address : String?)
    {
        userAddressMutable.value = address ?: return
    }

    /**
     * updateUserState method is used in UserAddressDetail Fragment.
     * */
    fun updateUserStateName(stateName : String?)
    {
        userStateNameMutable.value = stateName ?: return
    }
}