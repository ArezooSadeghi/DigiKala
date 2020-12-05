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

public class CategoryPageAdapter extends RecyclerView.Adapter<CategoryPageAdapter.CategoryPageViewHolder> {

    private Context mContext;
    private List<Product> mProductList;

    public CategoryPageAdapter(Context context, List<Product> productList) {
        mContext = context;
        mProductList = productList;
    }

    public List<Product> getProductList() {
        return mProductList;
    }

    public void setProductList(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public CategoryPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.category_page_item_detail,
                parent,
                false);
        return new CategoryPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryPageViewHolder holder, int position) {
        holder.bindProduct(mProductList.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class CategoryPageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageViewProduct;
        private TextView mTextViewProductName;

        public CategoryPageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewProduct = itemView.findViewById(R.id.img_product);
            mTextViewProductName = itemView.findViewById(R.id.txt_product_name);
        }

        public void bindProduct(Product product) {
            mTextViewProductName.setText(product.getProductName());
            Picasso.get().load(product.getProductImageUrl().get(0)).into(mImageViewProduct);
        }
    }
}
