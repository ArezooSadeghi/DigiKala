package com.example.digikala.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.digikala.model.Product;
import com.example.digikala.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private ProductRepository mRepository;
    private LiveData<List<Product>> mProductsLiveData;

    public ProductViewModel() {
        mRepository = ProductRepository.getInstance();
        mProductsLiveData = mRepository.getProductsLiveData();
    }

    public LiveData<List<Product>> getProductsLiveData() {
        return mProductsLiveData;
    }

    public void fetchProductItemsAsync() {
        mRepository.fetchProductItemsAsync();
    }

    public List<Product> getProductsByCategory(String categoryValue) {
        return mRepository.getProductsByCategory(categoryValue);
    }

    public Product getProduct(String productId) {
        return mRepository.getProduct(productId);
    }
}
