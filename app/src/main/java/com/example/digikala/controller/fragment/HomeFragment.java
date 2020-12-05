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

    private RecyclerView mRecyclerViewMostVisitedProduct,
            mRecyclerViewLatestProduct,
            mRecyclerViewBestProduct;

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
            public void onChanged(List<Product> productList) {
                setupAdapter(productList);
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
        mRecyclerViewBestProduct = view.findViewById(R.id.best_product_recycler_view);
        mRecyclerViewLatestProduct = view.findViewById(R.id.latest_product_recycler_view);
        mRecyclerViewMostVisitedProduct = view.findViewById(R.id.most_visited_product_recycler_view);
    }

    private void initViews() {
        LinearLayoutManager bestProductLayoutManager = new LinearLayoutManager(getContext());
        bestProductLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecyclerViewBestProduct.setLayoutManager(bestProductLayoutManager);

        LinearLayoutManager latestProductLayoutManager = new LinearLayoutManager(getContext());
        latestProductLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecyclerViewLatestProduct.setLayoutManager(latestProductLayoutManager);

        LinearLayoutManager mostVisitedProductLayoutManager = new LinearLayoutManager(getContext());
        mostVisitedProductLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecyclerViewMostVisitedProduct.setLayoutManager(mostVisitedProductLayoutManager);
    }

    private void setupAdapter(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList, getContext());

        mRecyclerViewMostVisitedProduct.setAdapter(adapter);
        mRecyclerViewLatestProduct.setAdapter(adapter);
        mRecyclerViewBestProduct.setAdapter(adapter);
    }
}