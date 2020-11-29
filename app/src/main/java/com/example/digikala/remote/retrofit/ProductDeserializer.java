package com.example.digikala.remote.retrofit;

import com.example.digikala.model.Product;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
            String productDescription = productObject.get("description").getAsString();
            JsonArray productImages = productObject.get("images").getAsJsonArray();

            Product product = new Product(
                    productName,
                    productPrice,
                    productId,
                    productRate,
                    productDescription);

            for (int j = 0; j < productImages.size(); j++) {
                JsonObject productImage = productImages.get(j).getAsJsonObject();

                String productImageUrl = productImage.get("src").getAsString();
                product.setProductImageUrl(productImageUrl);
            }
            productList.add(product);
        }
        return productList;
    }
}

