package com.chinkyfamily.livedatademo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
    private var containerGroup : ViewGroup? = null

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
        containerGroup = container
        _binding = FragmentUserDetailBinding.inflate(inflater , container , false)
        binding?.btnNextScreen?.setOnClickListener {
            userInfoViewModel.run {
                updateUserName(binding?.edtUserName?.text?.toString())
                updateUserMobileNumber(binding?.edtUserMobileNumber?.text?.toString())
            }
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace((containerGroup ?: return@setOnClickListener).id ,
                    ReviewDetail() ,
                    UserInfoActivity.REVIEW_DETAIL_FRAGMENT)
                ?.addToBackStack(UserInfoActivity.USER_DETAIL_FRAGMENT)?.commitAllowingStateLoss()
        }
        return binding?.root
    }

    /**
     * onResume callback method of the Fragment.
     * */
    override fun onResume()
    {
        super.onResume()
        binding?.edtUserName?.setText("")
        binding?.edtUserMobileNumber?.setText("")
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