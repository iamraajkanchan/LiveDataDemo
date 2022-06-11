package com.chinkyfamily.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chinkyfamily.livedatademo.databinding.ActivityUserInfoBinding

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
    }
}