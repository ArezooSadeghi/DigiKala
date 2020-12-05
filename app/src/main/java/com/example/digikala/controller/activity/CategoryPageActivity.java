package com.example.digikala.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.digikala.R;
import com.example.digikala.controller.fragment.CategoryPageFragment;

public class CategoryPageActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY_VALUE = "categoryValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);

        Intent intent = getIntent();
        String categoryValue = intent.getStringExtra(EXTRA_CATEGORY_VALUE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_category_page_container);

        if (fragment == null)
            fragmentManager.beginTransaction()
            .add(R.id.fragment_category_page_container, CategoryPageFragment.newInstance(categoryValue))
            .commit();
    }

    public static Intent newIntent(Context context, String categoryValue) {
        Intent intent = new Intent(context, CategoryPageActivity.class);
        intent.putExtra(EXTRA_CATEGORY_VALUE, categoryValue);
        return intent;
    }
}