package com.example.digikala.uicontroller.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.digikala.R;
import com.example.digikala.databinding.ActivityFragmentContainerBinding;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    private ActivityFragmentContainerBinding mBinding;

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        mBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_fragment_container);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null)
            fragmentManager.beginTransaction()
            .add(R.id.fragment_container, createFragment())
            .commit();
    }
}
