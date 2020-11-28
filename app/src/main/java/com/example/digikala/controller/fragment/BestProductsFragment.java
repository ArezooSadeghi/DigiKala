package com.example.digikala.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.adapter.ProductAdapter;
import com.example.digikala.model.Product;
import com.example.digikala.repository.ProductRepository;

import java.util.List;

public class BestProductsFragment extends Fragment {

    private RecyclerView mBestProduct;
    private ProductRepository mRepository;
    private TextView mBestProductTitle;

    public BestProductsFragment() {
    }

    public static BestProductsFragment newInstance() {
        BestProductsFragment fragment = new BestProductsFragment();
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
            public void onChanged(List<Product> products) {
                setupAdapter(products);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_best_products,
                container,
                false);

        findViews(view);
        initViews();

        return view;
    }

    private void findViews(View view) {
        mBestProduct = view.findViewById(R.id.best_product_recycler_view);
        mBestProductTitle = view.findViewById(R.id.txt_best_product_title);
    }

    private void initViews() {
        mBestProductTitle.setText(R.string.best_product_title);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBestProduct.setLayoutManager(layoutManager);
    }

    private void setupAdapter(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList, getContext());
        mBestProduct.setAdapter(adapter);
    }
}