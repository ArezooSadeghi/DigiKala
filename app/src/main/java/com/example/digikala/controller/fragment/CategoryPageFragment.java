package com.example.digikala.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digikala.R;
import com.example.digikala.adapter.CategoryPageAdapter;
import com.example.digikala.repository.ProductRepository;

public class CategoryPageFragment extends Fragment {

    public static final String ARGS_CATEGORY_VALUE = "categoryValue";

    private RecyclerView mRecyclerViewCategoryPage;
    private String mCategoryValue;
    private ProductRepository mRepository;

    public CategoryPageFragment() {
    }

    public static CategoryPageFragment newInstance(String categoryValue) {
        CategoryPageFragment fragment = new CategoryPageFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_CATEGORY_VALUE, categoryValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRepository = ProductRepository.getInstance();
        mCategoryValue = getArguments().getString(ARGS_CATEGORY_VALUE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category_page, container, false);

        findViews(view);
        initViews();
        setupAdapter();

        return view;
    }

    private void findViews(View view) {
        mRecyclerViewCategoryPage = view.findViewById(R.id.recycler_view_category_page);
    }

    private void initViews() {
        mRecyclerViewCategoryPage.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupAdapter() {
        CategoryPageAdapter adapter = new CategoryPageAdapter(
                getContext(),
                mRepository.getProductListByCategory(mCategoryValue));

        mRecyclerViewCategoryPage.setAdapter(adapter);
    }
}