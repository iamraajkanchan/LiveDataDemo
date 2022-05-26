package com.chinkyfamily.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.chinkyfamily.livedatademo.databinding.ActivityMainBinding

/**
 * Launcher and Main Activity of the application.
 * */
class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    private lateinit var mainActivityViewModelFactory : MainActivityViewModelFactory

    /**
     * onCreate callback method of MainActivity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        mainActivityViewModelFactory = MainActivityViewModelFactory()
        viewModel = ViewModelProvider(
            this , mainActivityViewModelFactory
        )[MainActivityViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}