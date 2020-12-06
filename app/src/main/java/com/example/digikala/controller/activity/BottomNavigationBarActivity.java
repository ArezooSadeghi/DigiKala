package com.example.digikala.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.digikala.R;
import com.example.digikala.controller.fragment.CartFragment;
import com.example.digikala.controller.fragment.CategoryFragment;
import com.example.digikala.controller.fragment.HomeFragment;
import com.example.digikala.controller.fragment.PersonFragment;
import com.example.digikala.databinding.ActivityBottomNavigationBarBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationBarActivity extends AppCompatActivity {

    private ActivityBottomNavigationBarBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_bottom_navigation_bar);

        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_home:
                                displayFragment(R.id.item_home);
                                return true;
                            case R.id.item_cart:
                                displayFragment(R.id.item_cart);
                                return true;
                            case R.id.item_category:
                                displayFragment(R.id.item_category);
                                return true;
                            default:
                                displayFragment(R.id.item_person);
                                return true;
                        }
                    }
                });
    }

    private void displayFragment(int itemId) {
        switch (itemId) {
            case R.id.item_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment.newInstance())
                        .commit();
                break;
            case R.id.item_cart:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, CartFragment.newInstance())
                        .commit();
                break;
            case R.id.item_category:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, CategoryFragment.newInstance())
                        .commit();
                break;
            default:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, PersonFragment.newInstance())
                        .commit();
                break;
        }
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, BottomNavigationBarActivity.class);
    }
}