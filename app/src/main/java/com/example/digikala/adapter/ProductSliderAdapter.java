package com.example.digikala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.digikala.R;
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
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.product_image_slider_item_detail,
                parent,
                false);
        return new ProductSliderViewHolder(view);
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

        private ImageView mImageViewProduct;

        public ProductSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewProduct = itemView.findViewById(R.id.img_product);
        }

        public void bindImage(String url) {
            Picasso.get().load(url).into(mImageViewProduct);
        }
    }
}
