package com.chinkyfamily.livedatademo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chinkyfamily.livedatademo.SharedViewModel
import com.chinkyfamily.livedatademo.TutorialActivity
import com.chinkyfamily.livedatademo.databinding.FragmentABinding

/**
 * FragmentA is used to insert text from User.
 * */
class FragmentA() : Fragment()
{
    private var viewModel : SharedViewModel? = null
    private var _binding : FragmentABinding? = null
    private val binding get() = _binding
    private var container : ViewGroup? = null

    /** onCreateView callback method of the Fragment. */
    override fun onCreateView(
        inflater : LayoutInflater ,
        container : ViewGroup? ,
        savedInstanceState : Bundle? ,
    ) : View?
    {
        _binding = FragmentABinding.inflate(inflater , container , false)
        this.container = container
        return binding?.root
    }

    /** onViewCreated callback method of the Fragment. */
    override fun onViewCreated(view : View , savedInstanceState : Bundle?)
    {
        super.onViewCreated(view , savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        (viewModel ?: return).getText().observe(viewLifecycleOwner) {
            binding?.editText?.setText(it)
        }
        binding?.buttonOk?.setOnClickListener(View.OnClickListener {
            (viewModel ?: return@OnClickListener).setText(binding?.editText?.text.toString())
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace((container ?: return@OnClickListener).id ,
                    FragmentB() ,
                    TutorialActivity.FRAGMENT_B)?.addToBackStack(TutorialActivity.FRAGMENT_A)
                ?.commit()
        })
    }
}