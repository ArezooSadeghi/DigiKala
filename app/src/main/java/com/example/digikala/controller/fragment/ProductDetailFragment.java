package com.example.digikala.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.digikala.R;
import com.example.digikala.model.Product;
import com.example.digikala.repository.ProductRepository;
import com.squareup.picasso.Picasso;

public class ProductDetailFragment extends Fragment {

    private static final String ARGS_PRODUCT_ID = "productId";
    private TextView mProductDescription, mProductDimensions;
    private ImageView mProductImage;
    private ProductRepository mRepository;
    private Product mProduct;

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

        View view = inflater.inflate(
                R.layout.fragment_product_detail,
                container,
                false);

        findViews(view);
        initViews(mProduct);

        return view;
    }

    private void findViews(View view) {
        mProductImage = view.findViewById(R.id.img_product);
        mProductDimensions = view.findViewById(R.id.txt_product_dimensions);
        mProductDescription = view.findViewById(R.id.txt_product_description);
    }

    private void initViews(Product product) {
        Picasso.get().load(product.getProductImageUrl()).into(mProductImage);
    }
}