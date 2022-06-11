package com.chinkyfamily.livedatademo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chinkyfamily.livedatademo.databinding.ActivityUserInfoBinding
import com.chinkyfamily.livedatademo.fragments.UserDetail

/**
 * UserInfoActivity holds the Fragments of this flow
 * */
class UserInfoActivity : AppCompatActivity()
{
    /**
     * onCreate callback method of the Activity.
     * @param savedInstanceState first parameter.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.fcvUserInfo.id , UserDetail.newInstance() , USER_DETAIL_FRAGMENT).commit()
    }

    companion object
    {
        /** Tag for UserDetail Fragment. */
        const val USER_DETAIL_FRAGMENT : String = "user detail fragment"

        /** Tag for UserAddressDetail Fragment */
        const val USER_ADDRESS_DETAIL : String = "user address detail fragment"

        /** Tag for ReviewDetail Fragment */
        const val REVIEW_DETAIL_FRAGMENT : String = "review detail fragment"
    }
}