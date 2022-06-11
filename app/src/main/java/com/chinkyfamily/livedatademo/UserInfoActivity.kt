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
        supportFragmentManager.beginTransaction()
            .add(R.id.fcvUserInfo , UserDetail() , USER_DETAIL_FRAGMENT).commitAllowingStateLoss()
    }

    companion object
    {
        /** Tag for UserDetail Fragment. */
        const val USER_DETAIL_FRAGMENT : String = "user detail fragment"

        /** Tag for ReviewDetail Fragment */
        const val REVIEW_DETAIL_FRAGMENT : String = "review detail fragment"
    }
}