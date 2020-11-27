package com.example.digikala.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.adapter.ProductAdapter;
import com.example.digikala.model.Product;
import com.example.digikala.repository.ProductRepository;

import java.util.List;

public class LatestProductsFragment extends Fragment {

    private RecyclerView mLatestProduct;
    private ProductRepository mRepository;

    public LatestProductsFragment() {
    }

    public static LatestProductsFragment newInstance() {
        LatestProductsFragment fragment = new LatestProductsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = ProductRepository.getInstance();
        mRepository.fetchProductItemsAsync();
        mRepository.getProductListLiveData().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> productList) {
                setupAdapter(productList);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_latest_products,
                container,
                false);

        findViews(view);
        initViews();

        return view;
    }

    private void findViews(View view) {
        mLatestProduct = view.findViewById(R.id.latest_product_recycler_view);
    }

    private void initViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mLatestProduct.setLayoutManager(layoutManager);
    }

    private void setupAdapter(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList, getContext());
        mLatestProduct.setAdapter(adapter);
    }
}