package com.chinkyfamily.livedatademo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chinkyfamily.livedatademo.UserInfoViewModel
import com.chinkyfamily.livedatademo.UserInfoViewModelFactory
import com.chinkyfamily.livedatademo.databinding.FragmentReviewDetailBinding

/**
 * ReviewDetail Fragment is used to review the details entered by a user.
 */
class ReviewDetail : Fragment()
{
    private lateinit var _binding : FragmentReviewDetailBinding
    private val binding get() = _binding
    private lateinit var userInfoViewModel : UserInfoViewModel

    /**
     * onCreateView callback method of the Fragment.
     * */
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View
    {
        _binding = FragmentReviewDetailBinding.inflate(inflater , container , false)
        return binding.root
    }

    /**
     * onViewCreated callback method of the Fragment.
     * */
    override fun onViewCreated(view : View , savedInstanceState : Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)
        val userInfoViewModelFactory = UserInfoViewModelFactory()
        userInfoViewModel = activity.run {
            ViewModelProvider(this@ReviewDetail ,
                userInfoViewModelFactory)[UserInfoViewModel::class.java]
        }
        userInfoViewModel.getUserName().observe(viewLifecycleOwner) {
            binding.tvUserMobileNumber.text = it
        }
        userInfoViewModel.getUserMobileNumber().observe(viewLifecycleOwner) {
            binding.tvUserMobileNumber.text = it
        }
        binding.btnExit.setOnClickListener {
            activity?.finish()
        }
    }

    companion object
    {
        /**
         * newInstance is factory method to create a new instance of ReviewDetail Fragment.
         * @return A new instance of fragment ReviewDetail.
         */
        @JvmStatic
        fun newInstance() : ReviewDetail = ReviewDetail()
    }
}