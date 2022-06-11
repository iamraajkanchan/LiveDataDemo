package com.chinkyfamily.livedatademo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chinkyfamily.livedatademo.R
import com.chinkyfamily.livedatademo.UserInfoActivity
import com.chinkyfamily.livedatademo.UserInfoViewModel
import com.chinkyfamily.livedatademo.UserInfoViewModelFactory
import com.chinkyfamily.livedatademo.databinding.FragmentUserDetailBinding

/**
 * UserDetail Fragment to take username and mobile number from a User.
 */
class UserDetail : Fragment()
{
    private var _binding : FragmentUserDetailBinding? = null
    private val binding get() = _binding
    private lateinit var userInfoViewModel : UserInfoViewModel

    /**
     * onCreate callback method of the Fragment.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        val userInfoViewModelFactory = UserInfoViewModelFactory()
        userInfoViewModel = activity.run {
            ViewModelProvider(this@UserDetail ,
                userInfoViewModelFactory)[UserInfoViewModel::class.java]
        }
    }

    /**
     * onCreateView callback method of the Fragment.
     * */
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle? ,
    ) : View?
    {
        _binding = FragmentUserDetailBinding.inflate(inflater , container , false)
        return binding?.root
    }

    /**
     * onViewCreated callback method of the Fragment.
     * */
    override fun onViewCreated(view : View , savedInstanceState : Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)
        binding?.btnNextScreen?.setOnClickListener {
            userInfoViewModel.run {
                updateUserName(binding?.edtUserName?.text?.toString())
                updateUserMobileNumber(binding?.edtUserMobileNumber?.text?.toString())
            }
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fcvUserInfo , ReviewDetail.newInstance() , "")
                ?.addToBackStack(UserInfoActivity.USER_DETAIL_FRAGMENT)?.commitAllowingStateLoss()
        }
    }

    companion object
    {
        /**
         * newInstance factory method is used to create a new instance of UserDetail Fragment.
         * @return A new instance of fragment UserDetail.
         */
        @JvmStatic
        fun newInstance() : UserDetail = UserDetail()
    }
}