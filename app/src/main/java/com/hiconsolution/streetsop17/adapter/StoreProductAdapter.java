package com.hiconsolution.streetsop17.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hiconsolution.streetsop17.ProductDetail;
import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.StoreProfileActivity;
import com.hiconsolution.streetsop17.models.StoreProductModel;

import java.util.ArrayList;


public class StoreProductAdapter extends RecyclerView.Adapter<StoreProductAdapter.ViewHolder> {


    private static ArrayList<StoreProductModel> storeProductModel;

    public StoreProductAdapter(ArrayList<StoreProductModel> storeModel) {

        storeProductModel = storeModel;
    }


    @Override
    public StoreProductAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.store_product_item, null);

        // create ViewHolder

        StoreProductAdapter.ViewHolder viewHolder = new StoreProductAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StoreProductAdapter.ViewHolder viewHolder, int i) {

        StoreProductModel productStoreModel = storeProductModel.get(i);

        viewHolder.productCategoryName.setText(productStoreModel.getName());
        viewHolder.productCategoryPrice.setText(productStoreModel.getPrice());

        viewHolder.productCategoryImage.setImageResource(productStoreModel.getThumbnail());
        viewHolder.feed = productStoreModel;
    }

    @Override
    public int getItemCount() {
        return storeProductModel.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productCategoryName, productCategoryPrice;
        public ImageView productCategoryImage;
        private Button productDetail;

        public StoreProductModel feed;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            productCategoryName = (TextView) itemLayoutView.findViewById(R.id.product_category_name);
            productCategoryPrice = (TextView) itemLayoutView.findViewById(R.id.product_category_price);
            productDetail = (Button) itemLayoutView.findViewById(R.id.product_detail);
            productCategoryImage = (ImageView) itemLayoutView.findViewById(R.id.product_category_image);

            productDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), ProductDetail.class);
                    v.getContext().startActivity(intent);
                    //Toast.makeText(v.getContext(), "click ", Toast.LENGTH_SHORT).show();
                }
            });

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), ProductDetail.class);
                    v.getContext().startActivity(intent);
                    //Toast.makeText(v.getContext(), "click ", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }
}
