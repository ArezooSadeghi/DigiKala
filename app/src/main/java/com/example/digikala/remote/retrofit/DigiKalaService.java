package com.example.digikala.remote.retrofit;

import com.example.digikala.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DigiKalaService {

    @GET("products?consumer key=ck_3bc440296ce055c52b5b7e421a0d48654ce215dd & " +
            "consumer secret=cs_a1062b3fc4224055d557cbc90a4323ca633f35aa")
    Call<List<Product>> getProductList();
}
