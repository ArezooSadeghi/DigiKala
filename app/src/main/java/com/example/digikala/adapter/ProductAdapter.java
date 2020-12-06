package com.example.digikala.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.controller.activity.ProductDetailContainer;
import com.example.digikala.databinding.ProductItemDetailBinding;
import com.example.digikala.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> mProductList;
    private Context mContext;

    public ProductAdapter(List<Product> productList, Context context) {
        mProductList = productList;
        mContext = context;
    }

    public List<Product> getProductList() {
        return mProductList;
    }

    public void setProductList(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemDetailBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.product_item_detail,
                parent,
                false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bindProduct(mProductList.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private Product mProduct;
        private ProductItemDetailBinding mProductItemDetailBinding;

        public ProductViewHolder(ProductItemDetailBinding productItemDetailBinding) {
            super(productItemDetailBinding.getRoot());
            productItemDetailBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = ProductDetailContainer
                            .newIntent(mContext, mProduct.getProductId());
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindProduct(Product product) {
            mProduct = product;
            mProductItemDetailBinding.txtProductName.setText(product.getProductName());
            String text = R.string.currency + product.getProductPrice();
            mProductItemDetailBinding
                    .txtProductPrice
                    .setText(product.getProductPrice() + " " + R.string.currency);
            Picasso.get()
                    .load(product.getProductImageUrl().get(0))
                    .into(mProductItemDetailBinding.imgProduct);
        }
    }
}
