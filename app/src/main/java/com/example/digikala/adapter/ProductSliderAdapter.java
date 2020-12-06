package com.example.digikala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.digikala.R;
import com.example.digikala.databinding.ProductImageSliderItemDetailBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductSliderAdapter extends SliderViewAdapter<ProductSliderAdapter.ProductSliderViewHolder> {

    private Context mContext;
    private List<String> mListProductImageUrl;

    public ProductSliderAdapter(Context context, List<String> listProductImageUrl) {
        mContext = context;
        mListProductImageUrl = listProductImageUrl;
    }

    public List<String> getListProductImageUrl() {
        return mListProductImageUrl;
    }

    public void setListProductImageUrl(List<String> listProductImageUrl) {
        mListProductImageUrl = listProductImageUrl;
    }

    @Override
    public ProductSliderViewHolder onCreateViewHolder(ViewGroup parent) {
        ProductImageSliderItemDetailBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.product_image_slider_item_detail,
                parent,
                false);
        return new ProductSliderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductSliderViewHolder viewHolder, int position) {
        viewHolder.bindImage(mListProductImageUrl.get(position));
    }

    @Override
    public int getCount() {
        return mListProductImageUrl.size();
    }

    public class ProductSliderViewHolder extends SliderViewAdapter.ViewHolder {

        private ProductImageSliderItemDetailBinding mProductImageSliderItemDetailBinding;

        public ProductSliderViewHolder(
                ProductImageSliderItemDetailBinding productImageSliderItemDetailBinding) {
            super(productImageSliderItemDetailBinding.getRoot());
        }

        public void bindImage(String url) {
            Picasso.get().load(url).into(mProductImageSliderItemDetailBinding.imgProduct);
        }
    }
}
