package com.example.digikala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digikala.R;
import com.example.digikala.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder> {

    private Context mContext;
    private List<Product> mProductCategoryList;

    public ProductCategoryAdapter(Context context, List<Product> productCategoryList) {
        mContext = context;
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
        View view = LayoutInflater
                .from(mContext)
                .inflate(R.layout.product_category_item_detail, parent, false);
        return new ProductCategoryViewHolder(view);
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

        private TextView mTextViewNumberOfProduct, mTextViewProductName;
        private ImageView mProductImage;

        public ProductCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewProductName = itemView.findViewById(R.id.txt_product_name);
            mTextViewNumberOfProduct = itemView.findViewById(R.id.txt_number_of_product);
            mProductImage = itemView.findViewById(R.id.img_product);
        }

        private void bindCategoryName(Product product) {
            Picasso.get().load(product.getProductImageUrl().get(0)).into(mProductImage);
        }
    }
}
