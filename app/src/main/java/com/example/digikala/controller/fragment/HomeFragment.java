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

public class HomeFragment extends Fragment {

    private RecyclerView mBestProduct, mLatestProduct, mMostVisitedProduct;
    private ProductRepository mRepository;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        findViews(view);
        initViews();

        return view;
    }

    private void findViews(View view) {
        mBestProduct = view.findViewById(R.id.best_product_recycler_view);
        mLatestProduct = view.findViewById(R.id.latest_product_recycler_view);
        mMostVisitedProduct = view.findViewById(R.id.most_visited_product_recycler_view);
    }

    private void initViews() {
        LinearLayoutManager bestLayoutManager = new LinearLayoutManager(getContext());
        bestLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBestProduct.setLayoutManager(bestLayoutManager);

        LinearLayoutManager latestLayoutManager = new LinearLayoutManager(getContext());
        latestLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mLatestProduct.setLayoutManager(latestLayoutManager);

        LinearLayoutManager mostVisitedLayoutManager = new LinearLayoutManager(getContext());
        mostVisitedLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mMostVisitedProduct.setLayoutManager(mostVisitedLayoutManager);
    }

    private void setupAdapter(List<Product> productList) {
        ProductAdapter bestProductAdapter = new ProductAdapter(productList, getContext());
        mBestProduct.setAdapter(bestProductAdapter);

        ProductAdapter latestProductAdapter = new ProductAdapter(productList, getContext());
        mLatestProduct.setAdapter(latestProductAdapter);

        ProductAdapter mostVisitedProductAdapter = new ProductAdapter(productList, getContext());
        mMostVisitedProduct.setAdapter(mostVisitedProductAdapter);
    }
}