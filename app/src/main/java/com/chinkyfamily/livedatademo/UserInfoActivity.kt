package com.chinkyfamily.livedatademo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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
     * @param savedInstanceState first parameter.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        _binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val userInfoViewModelFactory = UserInfoViewModelFactory()
        val userInfoViewModel =
            ViewModelProvider(this , userInfoViewModelFactory)[UserInfoViewModel::class.java]
        binding?.userInfoViewModel = userInfoViewModel
        binding?.lifecycleOwner = this
        val userDetailFragment = UserDetail.newInstance();
        supportFragmentManager.beginTransaction()
            .add(R.id.fcvUserInfo , userDetailFragment , USER_DETAIL_FRAGMENT)
            .commitAllowingStateLoss()
    }
}