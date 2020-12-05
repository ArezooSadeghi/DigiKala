package com.example.digikala.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.digikala.model.Product;
import com.example.digikala.remote.retrofit.DigiKalaService;
import com.example.digikala.remote.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    public static final String TAG = "ProductRepository";

    private MutableLiveData<List<Product>> mProductListLiveData = new MutableLiveData<>();
    private Map<String, String> mProductCategoryName = new HashMap<>();
    private static ProductRepository sInstance;
    private DigiKalaService mDigiKalaService;
    private List<Product> mProductList;


    private ProductRepository() {
        mDigiKalaService = RetrofitInstance.getInstance().create(DigiKalaService.class);
    }

    public static ProductRepository getInstance() {
        if (sInstance == null) {
            sInstance = new ProductRepository();
        }
        return sInstance;
    }

    public MutableLiveData<List<Product>> getProductListLiveData() {
        return mProductListLiveData;
    }

    public List<Product> getProductList() {
        return mProductList;
    }

    public Map<String, String> getProductCategoryName() {
        Map<String, String> productCategoryName = new HashMap<>();
        for (Product product:mProductList) {
            productCategoryName.putAll(product.getProductCategoryName());
        }
        return productCategoryName;
    }

    public void fetchProductItemsAsync() {
        Call<List<Product>> call = mDigiKalaService.getProductList();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mProductList = response.body();
                mProductListLiveData.setValue(mProductList);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }

    public Product getProduct(String productId) {
        for (Product product : mProductList) {
            if (product.getProductId().equals(productId))
                return product;
        }
        return null;
    }

    public List<Product> getProductListByCategory(String categoryValue) {
        List<Product> productList = new ArrayList<>();
        for (Product product:mProductList) {
            for (String value:product.getProductCategoryName().values()) {
                if (value.equals(categoryValue))
                    productList.add(product);
            }
        }
        return productList;
    }
}
