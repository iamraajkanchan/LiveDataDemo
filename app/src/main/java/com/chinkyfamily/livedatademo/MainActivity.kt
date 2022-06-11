package com.chinkyfamily.livedatademo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.chinkyfamily.livedatademo.databinding.ActivityMainBinding

/**
 * Launcher and Main Activity of the application.
 * */
class MainActivity : AppCompatActivity()
{
    private lateinit var _binding : ActivityMainBinding
    private val binding get() = _binding
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
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        mainActivityViewModelFactory = MainActivityViewModelFactory()
        viewModel = ViewModelProvider(this ,
            mainActivityViewModelFactory)[MainActivityViewModel::class.java]
        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this
    }

    /**
     * onStart callback method of the Activity.
     * */
    override fun onStart()
    {
        super.onStart()
        binding.btnNextScreen.setOnClickListener {
            Intent(this , UserInfoActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }

        binding.btnTutorialScreen.setOnClickListener {
            Intent(this , TutorialActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }
}