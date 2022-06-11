package com.chinkyfamily.livedatademo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.chinkyfamily.livedatademo.fragments.FragmentA;

public class TutorialActivity extends AppCompatActivity
{
    public static final String FRAGMENT_A = "Fragment A";
    public static final String FRAGMENT_B = "Fragment B";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        getSupportFragmentManager().beginTransaction().add(R.id.container_a, new FragmentA(), FRAGMENT_A).commit();
    }
}