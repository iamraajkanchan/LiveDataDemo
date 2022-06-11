package com.chinkyfamily.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chinkyfamily.livedatademo.databinding.ActivityUserInfoBinding
import com.chinkyfamily.livedatademo.fragments.UserDetail

const val USER_DETAIL_FRAGMENT : String = "user detail fragment"

/**
 * UserInfoActivity
 * */
class UserInfoActivity : AppCompatActivity()
{
    private var _binding : ActivityUserInfoBinding? = null
    private val binding get() = _binding

    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        _binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val userDetailFragment = UserDetail.newInstance();
        supportFragmentManager.beginTransaction()
            .add(R.id.fcvUserInfo , userDetailFragment , USER_DETAIL_FRAGMENT)
            .commitAllowingStateLoss()
    }
}