package com.example.digikala.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.digikala.model.Product;
import com.example.digikala.remote.retrofit.DigiKalaService;
import com.example.digikala.remote.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private MutableLiveData<List<Product>> mProductListLiveData = new MutableLiveData<>();
    public static final String TAG = "ProductRepository";
    private static ProductRepository sInstance;
    private DigiKalaService mDigiKalaService;

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

    public void fetchProductItemsAsync() {
        Call<List<Product>> call = mDigiKalaService.getProductList();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mProductListLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }
}
