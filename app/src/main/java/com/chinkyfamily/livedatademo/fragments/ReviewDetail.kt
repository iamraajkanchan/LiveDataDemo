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
    private lateinit var userInfoViewModel : UserInfoViewModel
    private lateinit var _binding : FragmentReviewDetailBinding
    private val binding get() = _binding

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
        userInfoViewModel = ViewModelProvider(requireActivity() ,
            UserInfoViewModelFactory())[UserInfoViewModel::class.java]
        binding.userInfoViewModel = userInfoViewModel
        binding.lifecycleOwner = this
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