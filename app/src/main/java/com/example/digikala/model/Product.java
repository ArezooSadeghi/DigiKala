package com.example.digikala.model;

import java.util.List;

public class Product {

    private String mProductName;
    private String mProductPrice;
    private String mProductId;
    private List<String> mProductImageUrl;
    private String mProductRate;
    private String mProductDescription;

    public Product() {
    }

    public Product(
            String productName,
            String productPrice,
            String productId,
            String productRate,
            String productDescription) {

        mProductName = productName;
        mProductPrice = productPrice;
        mProductId = productId;
        mProductRate = productRate;
        mProductDescription = productDescription;
    }

    public String getProductDescription() {
        return mProductDescription;
    }

    public void setProductDescription(String productDescription) {
        mProductDescription = productDescription;
    }

    public String getProductRate() {
        return mProductRate;
    }

    public void setProductRate(String productRate) {
        mProductRate = productRate;
    }

    public List<String> getProductImageUrl() {
        return mProductImageUrl;
    }

    public void setProductImageUrl(List<String> productImageUrl) {
        mProductImageUrl = productImageUrl;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public String getProductPrice() {
        return mProductPrice;
    }

    public void setProductPrice(String productPrice) {
        mProductPrice = productPrice;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String productId) {
        mProductId = productId;
    }
}
