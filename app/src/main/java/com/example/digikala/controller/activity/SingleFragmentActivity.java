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
        setContentView(R.layout.activity_product_list_container);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment bestProductFragment = fragmentManager
                .findFragmentById(R.id.best_product_fragment_container);
        if (bestProductFragment == null)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.best_product_fragment_container, createFragment().get(0))
                    .commit();


        Fragment latestProductFragment = fragmentManager
                .findFragmentById(R.id.latest_product_fragment_container);
        if (latestProductFragment == null)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.latest_product_fragment_container, createFragment().get(1))
                    .commit();


        Fragment mostVisitedProductFragment = fragmentManager
                .findFragmentById(R.id.most_visited_product_fragment_container);
        if (mostVisitedProductFragment == null)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.most_visited_product_fragment_container, createFragment().get(2))
                    .commit();
    }
}
