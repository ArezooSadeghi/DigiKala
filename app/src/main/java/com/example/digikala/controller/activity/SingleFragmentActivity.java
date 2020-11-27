package com.example.digikala.controller.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.digikala.R;

import java.util.List;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract List<Fragment> createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, createFragment().get(0))
                    .add(R.id.fragment_container, createFragment().get(1))
                    .add(R.id.fragment_container, createFragment().get(2))
                    .commit();
    }
}
