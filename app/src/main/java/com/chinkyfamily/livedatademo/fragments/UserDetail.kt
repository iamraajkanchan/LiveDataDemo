package com.chinkyfamily.livedatademo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chinkyfamily.livedatademo.databinding.FragmentUserDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserDetail : Fragment()
{
    // TODO: Rename and change types of parameters
    private var _binding : FragmentUserDetailBinding? = null
    private val binding get() = _binding

    /**
     * onCreate callback method of the Fragment.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    /**
     * onCreateView callback method of the Fragment.
     * */
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View?
    {
        _binding = FragmentUserDetailBinding.inflate(inflater , container , false)
        return binding?.root
    }

    companion object
    {
        /**
         * newInstance factory method is used to create a new instance of UserDetail Fragment.
         * @return A new instance of fragment UserDetail.
         */ // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() : UserDetail = UserDetail().apply {}
    }
}