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
import com.chinkyfamily.livedatademo.databinding.FragmentUserAddressDetailBinding

/**
 * create an instance of this fragment.
 */
class UserAddressDetail : Fragment()
{
    private var _binding : FragmentUserAddressDetailBinding? = null
    private val binding get() = _binding
    private var containerGroup : ViewGroup? = null

    /**
     * onCreateView callback method of the Activity.
     * */
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View?
    {
        containerGroup = container
        _binding = FragmentUserAddressDetailBinding.inflate(inflater , container , false)
        return binding?.root
    }

    /**
     * onViewCreated callback method of the Fragment.
     * */
    override fun onViewCreated(view : View , savedInstanceState : Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)
        val userInfoViewModel = ViewModelProvider(requireActivity() ,
            UserInfoViewModelFactory())[UserInfoViewModel::class.java]
        binding?.btnNextScreen?.setOnClickListener {
            userInfoViewModel.apply {
                updateUserAddress(binding?.edtUserAddress?.text?.toString())
                updateUserStateName(binding?.edtUserStateName?.text?.toString())
            }
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace((containerGroup ?: return@setOnClickListener).id ,
                    ReviewDetail.newInstance() ,
                    UserInfoActivity.REVIEW_DETAIL_FRAGMENT)
                ?.addToBackStack(UserInfoActivity.USER_ADDRESS_DETAIL)?.commit()
        }
    }

    companion object
    {
        /**
         * newInstance is a factory method to create a new instance of UserAddressDetail
         * @return A new instance of fragment UserAddressDetail.
         */
        @JvmStatic
        fun newInstance() : UserAddressDetail = UserAddressDetail()
    }

}