package com.example.digikala.uicontroller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.adapter.ProductAdapter;
import com.example.digikala.databinding.FragmentHomeBinding;
import com.example.digikala.model.Product;
import com.example.digikala.viewmodel.ProductViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private ProductViewModel mViewModel;

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

        mViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        mViewModel.fetchProductItemsAsync();
        setObserver();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false);

        initViews();

        return mBinding.getRoot();
    }


    private void setObserver() {
        mViewModel.getProductsLiveData().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> productList) {
                setupAdapter(productList);
            }
        });
    }


    private void initViews() {
        LinearLayoutManager bestProductLayoutManager = new LinearLayoutManager(getContext());
        bestProductLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.bestProductRecyclerView.setLayoutManager(bestProductLayoutManager);

        LinearLayoutManager latestProductLayoutManager = new LinearLayoutManager(getContext());
        latestProductLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.latestProductRecyclerView.setLayoutManager(latestProductLayoutManager);

        LinearLayoutManager mostVisitedProductLayoutManager = new LinearLayoutManager(getContext());
        mostVisitedProductLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mBinding.mostVisitedProductRecyclerView.setLayoutManager(mostVisitedProductLayoutManager);
    }

    private void setupAdapter(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList, getContext());

        mBinding.bestProductRecyclerView.setAdapter(adapter);
        mBinding.latestProductRecyclerView.setAdapter(adapter);
        mBinding.mostVisitedProductRecyclerView.setAdapter(adapter);
    }
}