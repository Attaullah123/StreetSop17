package com.hiconsolution.streetsop17.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hiconsolution.streetsop17.ProductDetail;
import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.models.StoreProductModel;

import java.util.ArrayList;

/**
 * Created by Attaullah Khizar on 10/09/2017.
 */

public class BestSellerAadapter extends RecyclerView.Adapter<BestSellerAadapter.ViewHolder> {


    private static ArrayList<StoreProductModel> storeProductModel;

    public BestSellerAadapter(ArrayList<StoreProductModel> storeModel) {

        storeProductModel = storeModel;
    }


    @Override
    public BestSellerAadapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.row_best_selling, null);

        // create ViewHolder

        BestSellerAadapter.ViewHolder viewHolder = new BestSellerAadapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BestSellerAadapter.ViewHolder viewHolder, int i) {

        StoreProductModel productStoreModel = storeProductModel.get(i);

       // viewHolder.productCategoryName.setText(productStoreModel.getName());
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

            productCategoryPrice = (TextView) itemLayoutView.findViewById(R.id.price1);
            productCategoryImage = (ImageView) itemLayoutView.findViewById(R.id.store_image);

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
