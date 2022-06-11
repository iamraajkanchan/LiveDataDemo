package com.chinkyfamily.livedatademo

import android.content.Intent
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

        /* Data Binding Technique - Working */

        // binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        /* View Binding Technique - Working */
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        mainActivityViewModelFactory = MainActivityViewModelFactory()
        viewModel = ViewModelProvider(
            this , mainActivityViewModelFactory
        )[MainActivityViewModel::class.java]
        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this
    }

    /**
     * onStart callback method of the Activity.
     * */
    override fun onStart()
    {
        super.onStart()
        binding?.btnNextScreen?.setOnClickListener {
            Intent(this , UserInfoActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }
}