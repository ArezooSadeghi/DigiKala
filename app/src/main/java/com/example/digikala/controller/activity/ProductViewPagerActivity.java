package com.example.digikala.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.digikala.R;
import com.example.digikala.controller.fragment.HomeFragment;
import com.example.digikala.controller.fragment.ProductCategoryFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProductViewPagerActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view_pager);

        findViews();
        initViews();
    }

    private void findViews() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
    }

    private void initViews() {
        mViewPager.setAdapter(new ProductViewPagerAdapter(this));
        new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.ic_category);
                        break;
                    default:
                        tab.setIcon(R.drawable.ic_home);
                        break;
                }
            }
        }).attach();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ProductViewPagerActivity.class);
    }

    private class ProductViewPagerAdapter extends FragmentStateAdapter {

        public static final int NUMBER_OF_PAGES = 2;

        public ProductViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return ProductCategoryFragment.newInstance();
                default:
                    return HomeFragment.newInstance();
            }
        }

        @Override
        public int getItemCount() {
            return NUMBER_OF_PAGES;
        }
    }
}