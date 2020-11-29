package com.example.digikala.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.digikala.R;
import com.example.digikala.controller.fragment.ProductDetailFragment;

public class ProductDetailContainer extends AppCompatActivity {

    public static final String EXTRA_PRODUCT_ID = "com.example.digikala.productId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product_container);

        Intent intent = getIntent();
        String productId = intent.getStringExtra(EXTRA_PRODUCT_ID);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.product_detail_container);

        if (fragment == null)
            fragmentManager.beginTransaction()
                    .add(R.id.product_detail_container, ProductDetailFragment.newInstance(productId))
                    .commit();
    }

    public static Intent newIntent(Context context, String productId) {
        Intent intent = new Intent(context, ProductDetailContainer.class);
        intent.putExtra(EXTRA_PRODUCT_ID, productId);
        return intent;
    }
}