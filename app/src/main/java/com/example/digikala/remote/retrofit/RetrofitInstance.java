package com.example.digikala.remote.retrofit;

import com.example.digikala.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://woocommerce.maktabsharif.ir/wp-json/wc/v3/")
                .addConverterFactory(createGsonConverter())
                .build();
    }

    public static Converter.Factory createGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<List<Product>>() {
        }.getType(), new ProductDeserializer());
        Gson gson = gsonBuilder.create();
        return GsonConverterFactory.create(gson);
    }
}
