package com.example.digikala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.databinding.ProductCategoryItemDetailBinding;
import com.example.digikala.databinding.ProductItemDetailBinding;
import com.example.digikala.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder> {

    private Context mContext;
    private List<Product> mProductCategoryList;

    public ProductCategoryAdapter(Context context, List<Product> productCategoryList) {
        mContext = context.getApplicationContext();
        mProductCategoryList = productCategoryList;
    }

    public List<Product> getProductCategoryList() {
        return mProductCategoryList;
    }

    public void setProductCategoryList(List<Product> productCategoryList) {
        mProductCategoryList = productCategoryList;
    }

    @NonNull
    @Override
    public ProductCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductCategoryItemDetailBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.product_category_item_detail,
                parent,
                false);
        return new ProductCategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryViewHolder holder, int position) {
        holder.bindCategoryName(mProductCategoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductCategoryList.size();
    }

    public class ProductCategoryViewHolder extends RecyclerView.ViewHolder {

        private ProductCategoryItemDetailBinding mProductCategoryItemDetailBinding;

        public ProductCategoryViewHolder(
                ProductCategoryItemDetailBinding productCategoryItemDetailBinding) {
            super(productCategoryItemDetailBinding.getRoot());
            mProductCategoryItemDetailBinding = productCategoryItemDetailBinding;
        }

        private void bindCategoryName(Product product) {
           mProductCategoryItemDetailBinding.setProduct(product);
        }
    }
}
