package com.example.digikala.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.digikala.R;
import com.example.digikala.adapter.ProductSliderAdapter;
import com.example.digikala.databinding.FragmentProductDetailBinding;
import com.example.digikala.model.Product;
import com.example.digikala.repository.ProductRepository;
import com.smarteist.autoimageslider.SliderView;

public class ProductDetailFragment extends Fragment {

    private static final String ARGS_PRODUCT_ID = "productId";

    private ProductRepository mRepository;
    private Product mProduct;
    private FragmentProductDetailBinding mBinding;

    public ProductDetailFragment() {
    }

    public static ProductDetailFragment newInstance(String productId) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_PRODUCT_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = ProductRepository.getInstance();
        String productId = getArguments().getString(ARGS_PRODUCT_ID);
        mProduct = mRepository.getProduct(productId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_product_detail,
                container,
                false);

        initViews(mProduct);

        return mBinding.getRoot();
    }

    private void initViews(Product product) {
        mBinding.txtProductDescription.setText(product.getProductDescription());
        ProductSliderAdapter adapter = new ProductSliderAdapter(
                getContext(),
                product.getProductImageUrl());
        mBinding.imgProductSlider.setSliderAdapter(adapter);
    }
}