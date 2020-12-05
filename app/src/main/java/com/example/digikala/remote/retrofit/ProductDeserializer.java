package com.example.digikala.remote.retrofit;

import android.text.Html;
import android.util.Log;

import com.example.digikala.model.Product;
import com.example.digikala.repository.ProductRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDeserializer implements JsonDeserializer<List<Product>> {

    @Override
    public List<Product> deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {

        List<Product> productList = new ArrayList<>();
        JsonArray bodyArray = json.getAsJsonArray();

        for (int i = 0; i < bodyArray.size(); i++) {
            JsonObject productObject = bodyArray.get(i).getAsJsonObject();

            String productId = productObject.get("id").getAsString();
            String productName = productObject.get("name").getAsString();
            String productPrice = productObject.get("price").getAsString();
            String productRate = productObject.get("average_rating").getAsString();
            String productDescription = Html.fromHtml(productObject.get("description").getAsString()).toString();

            Product product = new Product(
                    productName,
                    productPrice,
                    productId,
                    productRate,
                    productDescription);


            JsonArray productCategories = productObject.get("categories").getAsJsonArray();
            Map<String, String> productCategoryName = new HashMap<>();

            for (int j = 0; j < productCategories.size(); j++) {
                JsonObject productCategory = productCategories.get(j).getAsJsonObject();
                productCategoryName.put(productCategory.get("id").getAsString(), productCategory.get("name").getAsString());
            }

            product.setProductCategoryName(productCategoryName);

            JsonArray productImages = productObject.get("images").getAsJsonArray();
            List<String> productImageUrl = new ArrayList<>();

            for (int j = 0; j < productImages.size(); j++) {
                JsonObject productImage = productImages.get(j).getAsJsonObject();
                productImageUrl.add(productImage.get("src").getAsString());
            }

            product.setProductImageUrl(productImageUrl);
            productList.add(product);
        }
        return productList;
    }
}

