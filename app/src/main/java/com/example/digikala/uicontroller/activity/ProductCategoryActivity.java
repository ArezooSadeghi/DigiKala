package com.example.digikala.uicontroller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.digikala.uicontroller.fragment.ProductCategoryFragment;

public class ProductCategoryActivity extends SingleFragmentActivity {

    public static final String EXTRA_CATEGORY_VALUE = "categoryValue";

    private String mCategoryValue;

    @Override
    public Fragment createFragment() {
        return ProductCategoryFragment.newInstance(mCategoryValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        mCategoryValue = intent.getStringExtra(EXTRA_CATEGORY_VALUE);
    }

    public static Intent newIntent(Context context, String categoryValue) {
        Intent intent = new Intent(context, ProductCategoryActivity.class);
        intent.putExtra(EXTRA_CATEGORY_VALUE, categoryValue);
        return intent;
    }
}