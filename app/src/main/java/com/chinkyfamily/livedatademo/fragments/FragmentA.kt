package com.chinkyfamily.livedatademo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chinkyfamily.livedatademo.R;
import com.chinkyfamily.livedatademo.SharedViewModel;
import com.chinkyfamily.livedatademo.TutorialActivity;

public class FragmentA extends Fragment
{
    private SharedViewModel viewModel;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        editText = v.findViewById(R.id.edit_text);
        Button button = v.findViewById(R.id.button_ok);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                viewModel.setText(editText.getText());
                getActivity().getSupportFragmentManager().beginTransaction().replace(container.getId(), new FragmentB(), TutorialActivity.FRAGMENT_B).addToBackStack(TutorialActivity.FRAGMENT_A).commit();
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>()
        {
            @Override
            public void onChanged(@Nullable CharSequence charSequence)
            {
                editText.setText(charSequence);
            }
        });
    }
}