package com.example.digikala.model;

public class Product {

    private String mProductName;
    private String mProductPrice;
    private String mProductId;
    private String mProductImageUrl;

    public Product() {
    }

    public Product(String productName, String productPrice, String productId) {
        mProductName = productName;
        mProductPrice = productPrice;
        mProductId = productId;
    }

    public String getProductImageUrl() {
        return mProductImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
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
