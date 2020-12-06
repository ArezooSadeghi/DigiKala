package com.example.digikala.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.adapter.ProductCategoryAdapter;
import com.example.digikala.controller.activity.CategoryPageActivity;
import com.example.digikala.databinding.FragmentCategoryBinding;
import com.example.digikala.repository.ProductRepository;

public class CategoryFragment extends Fragment {

    private ProductRepository mRepository;
    private FragmentCategoryBinding mBinding;

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

        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_category,
                container,
                false);

        initViews();
        setupAdapter();
        setListeners();

        return mBinding.getRoot();
    }

    private void initViews() {
        LinearLayoutManager bagTowelLayoutManager = new LinearLayoutManager(getContext());
        bagTowelLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.recyclerViewBagTowelCategory.setLayoutManager(bagTowelLayoutManager);
        mBinding.txtBagTowelCategory.setText(R.string.bag_towel_category);

        LinearLayoutManager healthLayoutManager = new LinearLayoutManager(getContext());
        healthLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.recyclerViewHealthCategory.setLayoutManager(healthLayoutManager);
        mBinding.txtHealthCategory.setText(R.string.health_category);

        LinearLayoutManager digitalLayoutManager = new LinearLayoutManager(getContext());
        digitalLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.recyclerViewDigitalCategory.setLayoutManager(digitalLayoutManager);
        mBinding.txtDigitalCategory.setText(R.string.digital_category);

        LinearLayoutManager fashionClothingLayoutManager = new LinearLayoutManager(getContext());
        fashionClothingLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.recyclerViewFashionClothingCategory.setLayoutManager(fashionClothingLayoutManager);
        mBinding.txtFashionClothingCategory.setText(R.string.fashion_clothing_category);

        LinearLayoutManager phoneLayoutManager = new LinearLayoutManager(getContext());
        phoneLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.recyclerViewPhoneCategory.setLayoutManager(phoneLayoutManager);
        mBinding.txtPhoneCategory.setText(R.string.phone_category);

        LinearLayoutManager householdLayoutManager = new LinearLayoutManager(getContext());
        householdLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.recyclerViewHouseholdCategory.setLayoutManager(householdLayoutManager);
        mBinding.txtHouseholdCategory.setText(R.string.household_category);
    }

    private void setupAdapter() {
        ProductCategoryAdapter bagTowelAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.bag_towel_category)));
        mBinding.recyclerViewBagTowelCategory.setAdapter(bagTowelAdapter);

        ProductCategoryAdapter healthAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.health_category)));
        mBinding.recyclerViewHealthCategory.setAdapter(healthAdapter);

        ProductCategoryAdapter digitalAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.digital_category)));
        mBinding.recyclerViewDigitalCategory.setAdapter(digitalAdapter);

        ProductCategoryAdapter fashionClothingAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.fashion_clothing_category)));
        mBinding.recyclerViewFashionClothingCategory.setAdapter(fashionClothingAdapter);

        ProductCategoryAdapter phoneAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.phone_category)));
        mBinding.recyclerViewPhoneCategory.setAdapter(phoneAdapter);

        ProductCategoryAdapter householdAdapter = new ProductCategoryAdapter(
                getContext(),
                mRepository.getProductListByCategory(getString(R.string.household_category)));
        mBinding.recyclerViewHouseholdCategory.setAdapter(householdAdapter);
    }

    private void setListeners() {
        mBinding.txtBagTowelSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mBinding.txtBagTowelCategory.getText().toString());
                startActivity(intent);
            }
        });

        mBinding.txtHealthSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mBinding.txtHealthCategory.getText().toString());
                startActivity(intent);
            }
        });

        mBinding.txtDigitalSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mBinding.txtDigitalCategory.getText().toString());
                startActivity(intent);
            }
        });

        mBinding.txtFashionClothingSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mBinding.txtFashionClothingCategory.getText().toString());
                startActivity(intent);
            }
        });

        mBinding.txtPhoneSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mBinding.txtPhoneCategory.getText().toString());
                startActivity(intent);
            }
        });

        mBinding.txtHouseholdSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CategoryPageActivity.newIntent(
                        getContext(),
                        mBinding.txtHouseholdCategory.getText().toString());
                startActivity(intent);
            }
        });
    }
}