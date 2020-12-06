package com.example.digikala.uicontroller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.digikala.R;
import com.example.digikala.adapter.CategoryPageAdapter;
import com.example.digikala.databinding.FragmentProductCategoryBinding;
import com.example.digikala.viewmodel.ProductViewModel;

public class ProductCategoryFragment extends Fragment {

    public static final String ARGS_CATEGORY_VALUE = "categoryValue";

    private String mCategoryValue;
    private FragmentProductCategoryBinding mBinding;
    private ProductViewModel mViewModel;

    public ProductCategoryFragment() {
    }

    public static ProductCategoryFragment newInstance(String categoryValue) {
        ProductCategoryFragment fragment = new ProductCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_CATEGORY_VALUE, categoryValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        mCategoryValue = getArguments().getString(ARGS_CATEGORY_VALUE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_product_category,
                container,
                false);

        initViews();
        setupAdapter();

        return mBinding.getRoot();
    }

    private void initViews() {
        mBinding.recyclerViewCategoryPage.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupAdapter() {
        CategoryPageAdapter adapter = new CategoryPageAdapter(
                getContext(),
                mViewModel.getProductsByCategory(mCategoryValue));

        mBinding.recyclerViewCategoryPage.setAdapter(adapter);
    }
}