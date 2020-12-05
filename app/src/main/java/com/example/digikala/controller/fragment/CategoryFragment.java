package com.example.digikala.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.adapter.ProductCategoryAdapter;
import com.example.digikala.controller.activity.CategoryPageActivity;
import com.example.digikala.repository.ProductRepository;

public class CategoryFragment extends Fragment {

    private RecyclerView mBagTowel, mHealth, mDigital, mFashionClothing, mPhone, mHousehold;
    private TextView mTextViewBagTowel,
            mTextViewHealth,
            mTextViewDigital,
            mTextViewFashionClothing,
            mTextViewPhone,
            mTextViewHousehold,
            mTextViewSeeAllBagTowel,
            mTextViewSeeAllHealth,
            mTextViewSeeAllDigital,
            mTextViewSeeAllFashionClothing,
            mTextViewSeeAllPhone,
            mTextViewSeeAllHousehold;

    private ProductRepository mRepository;

    public CategoryFragment() {
    }

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = ProductRepository.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        findViews(view);
        initViews();
        setupAdapter();
        setListeners();

        return view;
    }


    private void findViews(View view) {
        mBagTowel = view.findViewById(R.id.recycler_view_bag_towel_category);
        mHealth = view.findViewById(R.id.recycler_view_health_category);
        mDigital = view.findViewById(R.id.recycler_view_digital_category);
        mFashionClothing = view.findViewById(R.id.recycler_view_fashion_clothing_category);
        mPhone = view.findViewById(R.id.recycler_view_phone_category);
        mHousehold = view.findViewById(R.id.recycler_view_household_category);
        mTextViewBagTowel = view.findViewById(R.id.txt_bag_towel_category);
        mTextViewHealth = view.findViewById(R.id.txt_health_category);
        mTextViewDigital = view.findViewById(R.id.txt_digital_category);
        mTextViewFashionClothing = view.findViewById(R.id.txt_fashion_clothing_category);
        mTextViewPhone = view.findViewById(R.id.txt_phone_category);
        mTextViewHousehold = view.findViewById(R.id.txt_household_category);
        mTextViewSeeAllBagTowel = view.findViewById(R.id.txt_bag_towel_see_all);
        mTextViewSeeAllHealth = view.findViewById(R.id.txt_health_see_all);
        mTextViewSeeAllDigital = view.findViewById(R.id.txt_digital_see_all);
        mTextViewSeeAllFashionClothing = view.findViewById(R.id.txt_fashion_clothing_see_all);
        mTextViewSeeAllPhone = view.findViewById(R.id.txt_phone_see_all);
        mTextViewSeeAllHousehold = view.findViewById(R.id.txt_household_see_all);
    }


    private void initViews() {
        LinearLayoutManager bagTowelLayoutManager = new LinearLayoutManager(getContext());
        bagTowelLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBagTowel.setLayoutManager(bagTowelLayoutManager);
        mTextViewBagTowel.setText(R.string.bag_towel_category);

        LinearLayoutManager healthLayoutManager = new LinearLayoutManager(getContext());
        healthLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mHealth.setLayoutManager(healthLayoutManager);
        mTextViewHealth.setText(R.string.health_category);

        LinearLayoutManager digitalLayoutManager = new LinearLayoutManager(getContext());
        digitalLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mDigital.setLayoutManager(digitalLayoutManager);
        mTextViewDigital.setText(R.string.digital_category);

        LinearLayoutManager fashionClothingLayoutManager = new LinearLayoutManager(getContext());
        fashionClothingLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mFashionClothing.setLayoutManager(fashionClothingLayoutManager);
        mTextViewFashionClothing.setText(R.string.fashion_clothing_category);

        LinearLayoutManager phoneLayoutManager = new LinearLayoutManager(getContext());
        phoneLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mPhone.setLayoutManager(phoneLayoutManager);
        mTextViewPhone.setText(R.string.phone_category);

        LinearLayoutManager householdLayoutManager = new LinearLayoutManager(getContext());
        householdLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mHousehold.setLayoutManager(householdLayoutManager);
        mTextViewHousehold.setText(R.string.household_category);
    }

    private void setupAdapter() {
        ProductCategoryAdapter bagTowelAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.bag_towel_category)));
        Log.d("Arezoo", "" + mRepository.getProductList().size());
        mBagTowel.setAdapter(bagTowelAdapter);

        ProductCategoryAdapter healthAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.health_category)));
        mHealth.setAdapter(healthAdapter);

        ProductCategoryAdapter digitalAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.digital_category)));
        mDigital.setAdapter(digitalAdapter);

        ProductCategoryAdapter fashionClothingAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.fashion_clothing_category)));
        mFashionClothing.setAdapter(fashionClothingAdapter);

        ProductCategoryAdapter phoneAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.phone_category)));
        mPhone.setAdapter(phoneAdapter);

        ProductCategoryAdapter householdAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.household_category)));
        mHousehold.setAdapter(householdAdapter);
    }

    private void setListeners() {
        mTextViewSeeAllBagTowel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mTextViewBagTowel.getText().toString());

                startActivity(intent);
            }
        });

        mTextViewSeeAllHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mTextViewHealth.getText().toString());

                startActivity(intent);
            }
        });

        mTextViewSeeAllDigital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mTextViewDigital.getText().toString());

                startActivity(intent);
            }
        });

        mTextViewSeeAllFashionClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mTextViewFashionClothing.getText().toString());

                startActivity(intent);
            }
        });

        mTextViewSeeAllPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mTextViewPhone.getText().toString());

                startActivity(intent);
            }
        });

        mTextViewSeeAllHousehold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mTextViewHousehold.getText().toString());

                startActivity(intent);
            }
        });
    }
}