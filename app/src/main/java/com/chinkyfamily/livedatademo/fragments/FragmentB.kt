package com.chinkyfamily.livedatademo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chinkyfamily.livedatademo.SharedViewModel
import com.chinkyfamily.livedatademo.databinding.FragmentBBinding

/**
 * Fragment B is used to show result from Fragment A
 * */
class FragmentB : Fragment()
{
    private var viewModel : SharedViewModel? = null
    private var _binding : FragmentBBinding? = null
    private val binding get() = _binding

    /**
     * onCreateView callback method of the Fragment.
     * */
    override fun onCreateView(
        inflater : LayoutInflater ,
        container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View?
    {
        _binding = FragmentBBinding.inflate(inflater , container , false)
        return binding?.root
    }

    /**
     * onViewCreated callback method of the Fragment.
     * */
    override fun onViewCreated(view : View , savedInstanceState : Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        (viewModel ?: return).getText().observe(viewLifecycleOwner) {
            binding?.editText?.setText(it)
        }
        binding?.buttonOk?.setOnClickListener {
            (viewModel ?: return@setOnClickListener).setText(binding?.editText?.text.toString())
            activity?.finish()
        }
    }
}