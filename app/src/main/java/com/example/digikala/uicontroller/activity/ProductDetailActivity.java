package com.example.digikala.uicontroller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.digikala.uicontroller.fragment.ProductDetailFragment;

public class ProductDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_PRODUCT_ID = "com.example.digikala.productId";

    private String mProductId;

    @Override
    public Fragment createFragment() {
        return ProductDetailFragment.newInstance(mProductId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        mProductId = intent.getStringExtra(EXTRA_PRODUCT_ID);

    }

    public static Intent newIntent(Context context, String productId) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra(EXTRA_PRODUCT_ID, productId);
        return intent;
    }
}