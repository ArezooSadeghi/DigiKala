package com.example.digikala.controller.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.digikala.controller.fragment.BestProductsFragment;
import com.example.digikala.controller.fragment.LatestProductsFragment;
import com.example.digikala.controller.fragment.MostVisitedProductsFragment;

import java.util.ArrayList;
import java.util.List;

public class ProductListContainer extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, ProductListContainer.class);
    }

    @Override
    public List<Fragment> createFragment() {
        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(BestProductsFragment.newInstance());
        fragmentList.add(LatestProductsFragment.newInstance());
        fragmentList.add(MostVisitedProductsFragment.newInstance());

        return fragmentList;
    }
}