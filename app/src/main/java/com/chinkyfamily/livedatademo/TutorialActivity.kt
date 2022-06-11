package com.chinkyfamily.livedatademo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chinkyfamily.livedatademo.fragments.FragmentA

/**
 * TutorialActivity
 * */
class TutorialActivity : AppCompatActivity()
{
    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        supportFragmentManager.beginTransaction().add(R.id.container_a , FragmentA() , FRAGMENT_A)
            .commit()
    }

    companion object
    {
        /** Tag for Fragment_A */
        const val FRAGMENT_A : String = "Fragment A"

        /** Tag for Fragment_B */
        const val FRAGMENT_B : String = "Fragment B"
    }
}